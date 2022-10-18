package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/example/features",
        glue = "org.example.steps",
        tags = "@hello_world or @another_test",
        stepNotifications = true,
        plugin = {"pretty", "html:target/cucumber.html",
                "junit:target/cucumber.xml",
                "json:target/cucumber-report.json"},
        monochrome = true
)

public class RunnerTest {
}
