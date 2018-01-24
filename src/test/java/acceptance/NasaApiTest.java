package acceptance;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import org.junit.runner.RunWith;
import steps.NasaApiTestSteps;

@RunWith(SerenityRunner.class)
public class NasaApiTest {

    @Steps
    NasaApiTestSteps testSteps;

    @Test()
    public void testAsteroidQueryById() {
        testSteps.setTheNasaAsteroidId("3542519");
        testSteps.getAsteroidResponse();
        testSteps.verifySuccessfullResponse();
        testSteps.verifyAsteroidName("(2010 PK9)");
    }
}
