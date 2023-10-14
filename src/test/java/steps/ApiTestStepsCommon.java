package steps;

import baseUri.ConfigReader;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.notNullValue;

public class ApiTestStepsCommon {
    protected Response response;

    @Dado("que a URI base é configurada")
    public void que_a_URI_base_é_configurada() {
        RestAssured.baseURI = ConfigReader.getBaseURI();
    }

}
