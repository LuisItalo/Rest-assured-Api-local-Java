package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", "html:target/report-cucumber.html"},
        tags = "@delete"
)
public class RunCucumberTests {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:3000/";
    }
}
