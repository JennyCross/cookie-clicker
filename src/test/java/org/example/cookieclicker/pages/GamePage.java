package org.example.cookieclicker.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GamePage extends AbstractBasePage {
    Locator headingLink;
    Locator welcomeText;
    Locator cookiesLabel;
    Locator cookieCount;
    Locator factoriesLabel;
    Locator factoryCount;
    Locator moneyLabel;
    Locator moneyTotal;
    Locator cookieClickButton;
    Locator sellCookiesInput;
    Locator sellCookiesButton;
    Locator buyFactoriesInput;
    Locator buyFactoriesButton;

    private static final Logger logger = LoggerFactory.getLogger(GamePage.class);

    public GamePage(Page page) {
        super(page);
        headingLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cookie Clicker!"));
        welcomeText = page.getByText("Hello ");
        cookiesLabel = page.getByText("Cookies:");
        cookieCount = page.locator("#cookies").first();
        factoriesLabel = page.getByText("Factories:");
        factoryCount = page.locator("#factories").first();
        moneyLabel = page.getByText("Money:");
        moneyTotal = page.locator("#money").first();
        cookieClickButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Click Cookie!"));
        sellCookiesInput = page.locator("#cookies-to-sell");
        sellCookiesButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sell Cookies!"));
        buyFactoriesInput = page.locator("#factories-to-buy");
        buyFactoriesButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buy Factories!"));
    }

    public void checkGameStarted(String name) {
        assertThat(headingLink).isVisible();
        assertThat(welcomeText).hasText("Hello %s".formatted(name));
        assertThat(cookiesLabel).isVisible();
        assertThat(cookieCount).hasText("0");
        assertThat(factoriesLabel).isVisible();
        assertThat(factoryCount).hasText("0");
        assertThat(moneyLabel).isVisible();
        assertThat(moneyTotal).hasText("0.0");
    }

    public void clickTheCookieButton() {
        cookieClickButton.click();
    }

    public void checkTheCookieTotal(String expectedTotal) {
        assertThat(cookieCount).hasText(expectedTotal);
    }

    public void sellSomeCookies(String sell) {
//        page.waitForTimeout(500);
//        String cookies = cookieCount.innerText();
        sellCookiesInput.fill(sell);
        sellCookiesButton.click();
//        assertThat(cookieCount).hasText(String.valueOf(Integer.parseInt(cookies) - Integer.parseInt(sell)));
    }

    public void checkTheMoneyTotal(String cash) {
        assertThat(moneyTotal).hasText(cash);
    }

    public void buyCookieFactories(String buy) {
        page.waitForTimeout(500);
        int factories = Integer.parseInt(factoryCount.innerHTML());
        int buyFactories = Integer.parseInt(buy);
        buyFactoriesInput.fill(buy);
        buyFactoriesButton.click();
        assertThat(factoryCount).not().hasText(String.valueOf(factories));
        assertThat(factoryCount).hasText(String.valueOf(factories + buyFactories));
    }

    public void checkTheCookieFactoryIsMakingCookies() {
        page.waitForTimeout(500);
        int cookies = Integer.parseInt(cookieCount.innerText());
        for (int i = 0; i < 5; i++) {
            assertThat(cookieCount).not().hasText(String.valueOf(cookies));
            int newTotal = Integer.parseInt(cookieCount.innerText());
            MatcherAssert.assertThat(newTotal, Matchers.greaterThan(cookies));
            logger.info("Cookie count increased automatically from {} to {}", cookies, newTotal);
            cookies = newTotal;
        }
    }
}
