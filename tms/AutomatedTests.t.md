# AutomatedTests

* 1 \<PlayerName> clicks the cookie button \<ClickCount> times
    * Given \<PlayerName> starts a game
    * When the cookie is clicked \<ClickCount> times
    * Then the cookie count is now \<ClickCount>

* 2 \<PlayerName> clicks the cookie button \<ClickCount> times and sells \<SellCookies> cookie(s)
    * Given \<PlayerName> starts a game
    * When the cookie is clicked \<ClickCount> times
    * And they sell \<SellCookies> cookies
    * Then the cookie count has been adjusted
    * And Money is now \<Cash>

* 3 \<PlayerName> clicks the cookie button \<ClickCount> times and buys \<Factories> factories
    * Given \<PlayerName> starts a game
    * When the cookie is clicked \<ClickCount> times
    * And they sell \<SellCookies> cookies
    * And they buy \<Factories> factories
    * Then the cookie count increases on its own