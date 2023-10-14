package steps;

import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;

import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTestStepsDelete {

    private ApiTestStepsCommon commonSteps = new ApiTestStepsCommon();

    @Quando("eu enviar uma requisição DELETE para excluir o cliente em {string}")
    public void eu_enviar_uma_requisição_DELETE_para_excluir_o_cliente_em(String endpoint) {
        // Enviar a requisição DELETE
       commonSteps.response  = RestAssured.delete(endpoint);
    }

    @Então("a resposta deve ser {int}")
    public void a_resposta_deve_ser(Integer statusCode) {

        // Verificar o código de resposta
        commonSteps.response
                .then()
                .statusCode(statusCode);
    }


}
