Feature: Sell Cookies
  Background: Scenario background repeated for each scenario
    * Open Cookie Clicker App
    * Cookies have been cleared

  Scenario Outline: <PlayerName> clicks the cookie button <ClickCount> times and sells <SellCookies> cookie(s)
    Given <PlayerName> starts a game
    When the cookie is clicked <ClickCount> times
    And they sell <SellCookies> cookies
    Then the cookie count has been adjusted
    And Money is now <Cash>
    Examples:
      | PlayerName | ClickCount | SellCookies | Cash |
      | Gill       | 1          | 1           | 0.25 |
      | Bob        | 5          | 1           | 0.25 |
      | Frank      | 10         | 2           | 0.5  |
      | Julie      | 15         | 3           | 0.75 |
      | Spencer    | 20         | 4           | 1.0  |
      | Mary       | 25         | 26          | 0.0  |
      | Heather    | 30         | -1          | 0.0  |
      | Jason      | 35         | B           | 0.0  |
