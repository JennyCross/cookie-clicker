package org.example.cookieclicker.pages;

import com.microsoft.playwright.Page;

public abstract class AbstractBasePage {
    Page page;
    public AbstractBasePage(Page page) {
        this.page = page;
    }
}
