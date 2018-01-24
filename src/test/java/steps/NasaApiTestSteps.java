package steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.CoreMatchers.is;

public class NasaApiTestSteps {

    private static final String API_KEY = "DEMO_KEY";
    private static final String URL_ASTEROID_QUERY = "https://api.nasa.gov/neo/rest/v1/neo/{0}?api_key={1}";

    private String asteroidId;
    private Response response;

    @Step("Given I have the NASA asteroid id: {0}")
    public void setTheNasaAsteroidId(String asteroidId) {
        this.asteroidId = asteroidId;
    }

    @Step("When I query NASA API with given asteroid id")
    public void getAsteroidResponse() {
        this.response = SerenityRest.when().get(URL_ASTEROID_QUERY, asteroidId, API_KEY);
    }

    @Step("Then I get a successful response")
    public void verifySuccessfullResponse() {
        this.response.then().assertThat().statusCode(200);
    }

    @Step("And returned asteroid name is: {0}")
    public void verifyAsteroidName(String asteroidName) {
        this.response.then().body("name", is(asteroidName));
    }
}
