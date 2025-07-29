package org.example.cookieclicker.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.cookieclicker.pages.GamePage;
import org.example.cookieclicker.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Stepdefs {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
    HomePage homePage;
    GamePage gamePage;
    private int cookieTotal = 0;
    private int soldCookies = 0;

    private static final Logger logger = LoggerFactory.getLogger(Stepdefs.class);

    @Before
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(Boolean.parseBoolean(System.getProperty("headless", "true"))));
    }

    @Before(order = 20000)
    public void createContextAndPage(Scenario scenario) {
        context = browser.newContext();
        page = context.newPage();
        logger.info("Starting scenario: {}", scenario.getName());
    }

    @After(order = 20000)
    public void closeContext(Scenario scenario) {
        logger.info("Finished scenario: {}", scenario);
        context.close();
    }

    @After
    public void closePlaywright() {
        playwright.close();
    }

    @When("Open Cookie Clicker App")
    public void openCookieClickerApp() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        homePage = new HomePage(page);
        gamePage = new GamePage(page);

        homePage.navigate(properties.getProperty("url"));
    }

    @When("Cookies have been cleared")
    public void cookiesHaveBeenCleared() {
        context.clearCookies();
    }

    @Given("{} starts a game")
    public void startsAGame(String name) {
        homePage.startGame(name);
        gamePage.checkGameStarted(name);
    }

    @When("the cookie is clicked {} times")
    public void theCookieIsClickedTimes(String clicks) {
        for (int i = 0; i < Integer.parseInt(clicks); i++) {
            gamePage.clickTheCookieButton();
            this.cookieTotal++;
        }
    }

    @Then("the cookie count is now {}")
    public void theCookieCountIsNow(String expectedTotal) {
        gamePage.checkTheCookieTotal(expectedTotal);
    }

    @And("they sell {} cookies")
    public void theySellCookies(String sell) {
        this.soldCookies = Integer.parseInt(sell);
        gamePage.sellSomeCookies(sell);
    }

    @Then("the cookie count has been adjusted")
    public void theCookieCountHasBeenAdjusted() {
        gamePage.checkTheCookieTotal(String.valueOf(this.cookieTotal - this.soldCookies));
    }

    @And("Money is now {}")
    public void moneyIsNow(String cash) {
        gamePage.checkTheMoneyTotal(cash);
    }

    @And("they buy {} factories")
    public void theyBuyFactories(String buy) {
        gamePage.buyCookieFactories(buy);
    }

    @Then("the cookie count increases on its own")
    public void theCookieCountIncreasesOnItsOwn() {
        gamePage.checkTheCookieFactoryIsMakingCookies();
    }
}
