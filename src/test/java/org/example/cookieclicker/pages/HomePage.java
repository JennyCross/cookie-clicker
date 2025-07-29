package org.example.cookieclicker.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage extends AbstractBasePage{
    Locator heading;
    Locator playerNameInput;
    Locator startGameButton;

    public HomePage(Page page) {
        super(page);
        heading = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Cookie Clicker!"));
        playerNameInput = page.getByRole(AriaRole.TEXTBOX);
        startGameButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start!"));
    }

    public void navigate(String url) {
        this.page.navigate(url);
        assertThat(heading).isVisible();
    }

    public void startGame(String name) {
        playerNameInput.fill(name);
        startGameButton.click();
    }
}
