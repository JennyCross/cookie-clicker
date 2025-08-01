# Cookie Cutter Test Suite
> Cookie Clicker technical interview submission for Aire Logic by Jennifer Cross

> In creating this automation framework, I wanted to demonstrate the usage report I mentioned during my first interview.
> This dictated the use of Cucumber 6  due to the usage report being broken in Cucumber 7.
> JUnit4 was used instead of JUnit5 because of compatibility issues with Maven which cause tests to run twice.

## Prerequisites
- Java 21 (LTS)
- Maven

## Features Implemented
- [X] Playwright for Java
- [x] JUnit4
- [X] Cucumber BDD
- [X] PageObject Model
- [X] HTML Report
- [X] JSON Results File
- [X] Usage Report
- [X] Timeline Report
- [X] Logger
- [ ] Cross-Browser Testing
- [ ] Parallel Execution

## Execution

### Linux/MacOS
```Bash
  ./mvnw clean test
```
```Bash
  ./mvnw -Dheadless=false clean test
```

### Windows
```Bash
  mvnw.cmd clean test
```
```Bash
  mvnw.cmd -Dheadless=false clean test
```

## Playwright

> Playwright was used because it provides easy automation of web pages out of the box with built in waits and driver management.
> It also provides superior tools to help develop a test suite and maintain it.

### Page Inspector
```Bash
  ./mvnw exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen Jenny-Cross-2025-07-22.cookieclickertechtest.airelogic.com"
```

### Debug Tool
```Bash
  PWDEBUG=1 ./mvnw clean test
```

## Reports

- [Cucumber HTML Report](./target/cucumber/results.html)
- [Cucumber Timeline Report](./target/cucumber/timeline/index.html)
- [Cucumber Results XML](./target/cucumber/results.xml)
- [Cucumber Results JSON](./target/cucumber/results.json)
- [Cucumber Rerun File](./target/cucumber/rerun.txt)
- [Cucumber Usage JSON](./target/cucumber/usage.json)

## TMS
### Readable via JetBrains TMS in IntelliJ IDEA
- [Manual Tests](./tms/ManualTests.t.md)
- [Automated Tests](./tms/AutomatedTests.t.md)

### Not Readable via JetBrains TMS in IntelliJ IDEA
- [Bugs found](./tms/Bugs.md)

## Additional Testing not considered for this exercise
- Performance Testing
- Accessibility Testing
- Security Testing
- Deployment Testing

## I tried but I think the maven dependency is too far gone
> The dependency to produce the Step Usage Report I mentioned during the first interview hasn't been maintained for a long time.
> Most likely as a result of the usage plugin being broken in Cucumber7.
> 
> Thsi is what it would have looked like. 

![CucumberUsageReport](./images/usage-report.png)
