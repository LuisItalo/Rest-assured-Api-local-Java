package steps;

import baseUri.ConfigReader;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTestStepsPut {
    private ApiTestStepsCommon commonSteps = new ApiTestStepsCommon();
    private String requestBody;

    @E("o corpo da requisição PUT é configurado")
    public void o_corpo_da_requisição_é_configurado() {
        // Configurar o corpo da requisição (por exemplo, um objeto JSON)
        requestBody = "{\"nome\": \"Novo Nome\", \"endereco\": \"Novo Endereço2\", \"email\": \"novo_email2@email.com\", \"telefone\": \"124534676\"}";
    }

    @Quando("eu enviar uma requisição PUT para atualizar o cliente em {string}")
    public void eu_enviar_uma_requisição_PUT_para_atualizar_o_cliente_em(String endpoint) {
        // Enviar a requisição PUT
        commonSteps.response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(endpoint);
    }

    @Então("o código de resposta deve ser {int}")
    public void o_código_de_resposta_deve_ser(Integer statusCode) {
        // Verificar o código de resposta
        commonSteps.response.then().statusCode(statusCode);
    }

    @Então("a resposta deve conter informações atualizadas do cliente")
    public void a_resposta_deve_conter_informações_atualizadas_do_cliente() {
        // Verificar se a resposta contém as informações atualizadas do cliente
        commonSteps.response.then()
                .body("mensagem", equalTo("Cliente atualizado com sucesso"));
    }
}
