package com.algaworks.algafoodapi;



import com.algaworks.algafoodapi.domain.entity.Cozinha;
import com.algaworks.algafoodapi.domain.repository.ICozinhaRepository;
import com.algaworks.algafoodapi.util.DatabaseCleaner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@TestPropertySource("/application-test.properties")
public class CadastroCozinnhaTest {


    @LocalServerPort
    private int porta;

    @Autowired
    private DatabaseCleaner databaseCleaner;

    @Autowired
    private ICozinhaRepository cozinhaRepository;

    @Before("")
    public void setUp(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        databaseCleaner.clearTables();
        prepararDados();

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
                .body("nome", Matchers.hasSize(2))
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

    @Test
    public void deveRetornarRespostaEStatusCorretos_QuandoConsultarCozinhaExistente(){

        RestAssured.given()
                .basePath("/cozinhas")
                .pathParam("Id",2)
                .port(porta)
                .accept(ContentType.JSON)
                .when()
                .get("/{Id}")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body("nome",equalTo("americana"));
    }



    private void prepararDados(){
        Cozinha cozinha = new Cozinha();
        cozinha.setNome("tailandesa");
        cozinhaRepository.save(cozinha);
        Cozinha cozinha1 = new Cozinha();
        cozinha1.setNome("americana");
        cozinhaRepository.save(cozinha1);
    }

}
