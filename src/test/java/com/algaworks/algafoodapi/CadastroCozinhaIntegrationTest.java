package com.algaworks.algafoodapi;

import com.algaworks.algafoodapi.api.service.CozinhaService;
import com.algaworks.algafoodapi.api.service.exception.DataBaseIntegrety;
import com.algaworks.algafoodapi.domain.entity.Cozinha;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class CadastroCozinhaIntegrationTest {

	@Autowired
	private CozinhaService cozinhaService;


	@Test
	public void testarCadastroCozinhaComSucesso(){
			var novaCozinha = new Cozinha();
			novaCozinha.setNome("Chinesa");

			novaCozinha = cozinhaService.criar(novaCozinha);

			Assertions.assertNotNull(novaCozinha);
			Assertions.assertNotNull(novaCozinha.getId());

	}

	@Test
	public void deveFalharAoCadastrarCozinhaQuandoSemNome(){
		Assertions.assertThrows(ConstraintViolationException.class,()->{

		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

			novaCozinha = cozinhaService.criar(novaCozinha);
		});
	}
	@Test
	public void deveFalharQuandoEcluirUmaCozinhaEmUso(){
		Assertions.assertThrows(DataBaseIntegrety.class,()->{

			cozinhaService.delete(1l);
		});
	}

	@Test
	public void deveFalharQuandoCozinhaNaoExistir(){
		Assertions.assertThrows(EmptyResultDataAccessException.class,()->{

			cozinhaService.delete(100l);
		});
	}





}
