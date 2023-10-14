package baseUri;

import io.restassured.RestAssured;

public class ConfigReader {
    // Não é mais necessário ler a URI de um arquivo, pois ela é definida diretamente no run.java
    public static String getBaseURI() {
        // Retorna a URI base diretamente no método
        return RestAssured.baseURI;
    }
}
