package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.messages.internal.com.google.gson.JsonObject;
import io.restassured.RestAssured;

import static org.hamcrest.CoreMatchers.notNullValue;


public class ApiTestStepsPost {

    private ApiTestStepsCommon commonSteps = new ApiTestStepsCommon();
    private JsonObject requstBody;

    @E("o corpo da requisição POST é configurado")
    public void o_corpo_da_requisição_POST_é_configurado() {
        // Configurar o corpo da requisição POST (por exemplo, um objeto JSON)
        requstBody = new JsonObject();
        requstBody.addProperty("id_cliente", "4");
        requstBody.addProperty("nome", "Teo");
        requstBody.addProperty("endereco", "caixaPrega");
        requstBody.addProperty("email", "teo@email.com");
        requstBody.addProperty("senha", "domato");
        requstBody.addProperty("telefone", "69693959395");

    }

    @Quando("eu enviar uma requisição POST para criar um cliente em {string}")
    public void eu_enviar_uma_requisição_POST_para_criar_um_cliente_em(String endpoint) {
        // Enviar a requisição POST
        commonSteps.response = RestAssured.given()
                .contentType("application/json")
                .body(requstBody.toString())
                .post(endpoint);
    }

    @Então("o código de resposta no POST deve ser {int}")
    public void o_código_de_resposta_no_POST_deve_ser(Integer statusCode) {
        // Verificar o código de resposta
        commonSteps.response
                .then()
                .statusCode(statusCode);
    }
    @Então("a resposta deve conter o ID do cliente criado")
    public void a_resposta_deve_conter_o_ID_do_cliente_criado() {
        // Verificar se a resposta contém o ID do cliente criado
        // Implemente a verificação de acordo com sua necessidade
        commonSteps.response
                .then()
                .body("id", notNullValue());

    }
}
