Feature: Cookie Clicker
  Background: Scenario background repeated for each scenario
    * Open Cookie Clicker App
    * Cookies have been cleared

  Scenario Outline: <PlayerName> clicks the cookie button <ClickCount> times
    Given <PlayerName> starts a game
    When the cookie is clicked <ClickCount> times
    Then the cookie count is now <ClickCount>
    Examples:
      | PlayerName | ClickCount |
      | Gill       | 1          |
      | Bob        | 5          |
      | Frank      | 10         |
      | Julie      | 15         |
      | Spencer    | 20         |
      | Mary       | 25         |
      | Heather    | 30         |
      | Jason      | 35         |
