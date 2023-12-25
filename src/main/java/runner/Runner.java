package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Cucumber_FeatureFiles/TC_01_Cucumber_LoginFunctionality.feature"},
        glue = "stepDef",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner extends AbstractTestNGCucumberTests {
}
