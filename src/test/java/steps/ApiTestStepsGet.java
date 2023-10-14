package steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static io.restassured.RestAssured.get;

public class ApiTestStepsGet {

    private ApiTestStepsCommon commonSteps = new ApiTestStepsCommon();

    @Quando("eu enviar uma requisição GET para obter o cliente em {string}")
    public void eu_enviar_uma_requisição_GET_para_obter_o_cliente_em(String uri) {
        commonSteps.response = get(uri);
    }

    @Então("o código de resposta no GET deve ser {int}")
    public void o_código_de_resposta_no_GET_deve_ser(Integer statusCode) {
        commonSteps.response
                .then()
                .statusCode(statusCode)
                .log().all();
    }
    @Então("a resposta deve conter informações do cliente")
    public void a_resposta_deve_conter_informações_do_cliente() {
        // Verificar se a resposta contém as informações do cliente
        // Implemente a verificação de acordo com sua necessidade
        // Para cliente especificos passando o id nas features
//        commonSteps.response.then()
//                .body("id_cliente", notNullValue())
//                .body("nome", equalTo("Novo Nome"))
//                .body("endereco", equalTo("Novo Endereço"))
//                .body("email", equalTo("novo_email@email.com"));
    }
}
