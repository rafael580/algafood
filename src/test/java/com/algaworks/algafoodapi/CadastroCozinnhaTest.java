package com.algaworks.algafoodapi;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.aspectj.lang.annotation.Before;
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

    @Before("")
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @Test
    public void deveRetornarStatus200QuandoConsultarCozinhas(){



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

    @Test
    public void deveRetornarStatus201_QuandoCadastrarCozinha(){
        RestAssured.given()
                .basePath("/cozinhas")
                .port(porta)
                .body("{ \"nome\": \"Chinesa\" }")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .post()
                .then()
                .statusCode(HttpStatus.CREATED.value());

    }

}
