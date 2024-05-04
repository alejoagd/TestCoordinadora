package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", // Directorio de nuestros archivos features
    glue ="steps", // paq donde tenemos definidos los steps
    plugin = {"pretty","html:target/cucumber-reports"}, tags = "@Solicitud") 

public class TestRunner {

}
