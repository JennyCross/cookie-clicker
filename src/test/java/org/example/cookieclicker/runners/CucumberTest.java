package org.example.cookieclicker.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = {"src/test/resources/features"},
        glue = {"org.example.cookieclicker.steps"},
        plugin = {
                "pretty",
                "html:target/cucumber/results.html",
                "junit:target/cucumber/results.xml",
                "json:target/cucumber/results.json",
                "timeline:target/cucumber/timeline",
                "rerun:target/cucumber/rerun.txt",
                "usage:target/cucumber/usage.json"
        }
)
public class CucumberTest {
}
