Feature: Buy Factories

  Background: Scenario background repeated for each scenario
    * Open Cookie Clicker App
    * Cookies have been cleared

  Scenario Outline: <PlayerName> clicks the cookie button <ClickCount> times and buys <Factories> factories
    Given <PlayerName> starts a game
    When the cookie is clicked <ClickCount> times
    And they sell <SellCookies> cookies
    And they buy <Factories> factories
    Then the cookie count increases on its own
    Examples:
      | PlayerName | ClickCount | SellCookies | Factories |
      | Gill       | 1          | 0           | 1         |
      | Bob        | 5          | 12          | 1         |
      | Frank      | 10         | 12          | 1         |
      | Julie      | 15         | 12          | 1         |
      | Spencer    | 20         | 12          | 2         |
      | Mary       | 25         | 24          | 2         |
      | Heather    | 30         | 24          | -3        |
      | Jason      | 35         | 24          | C         |
