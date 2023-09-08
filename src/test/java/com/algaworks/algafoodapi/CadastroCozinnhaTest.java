package com.algaworks.algafoodapi;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional

public class CadastroCozinnhaTest {


    @LocalServerPort
    private int porta;

    @Test
    public void deveRetornarStatus200QuandoConsultarCozinhas(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.given()
                .basePath("/cozinhas")
                .port(porta)
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    @Test
    public void deveContar4CozinhasQuandoConsultarCozinhas(){

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.given()
                .basePath("/cozinhas")
                .port(porta)
                .accept(ContentType.JSON)
                .when()
                .get()
                .then()
                .body("nome", Matchers.hasSize(4))
                .body("nome",Matchers.hasItems("indiana"));
    }

}
