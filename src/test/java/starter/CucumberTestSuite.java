package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = "@Latihan", //Tugas
        plugin = {"pretty"},
        features = "classpath:features/Regres"
)
public class CucumberTestSuite {}
