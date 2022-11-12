package bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"bdd/defSteps", "bdd/hooks"},
        tags = "@RegularTest or @SampleTest"
)
public class RunCucumberTest {

}
