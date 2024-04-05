package br.com.cotiinformatica.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.domain.dtos.AutenticarClienteRequestDto;
import br.com.cotiinformatica.domain.dtos.AutenticarClienteResponseDto;
import br.com.cotiinformatica.domain.dtos.CriarClienteRequestDto;
import br.com.cotiinformatica.domain.dtos.CriarClienteResponseDto;
import br.com.cotiinformatica.domain.interfaces.ClienteDomainService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/clientes")
public class ClientesController {

	@Autowired
	private ClienteDomainService clienteDomainService;

	@PostMapping("criar")
	public ResponseEntity<CriarClienteResponseDto> criar(@Valid @RequestBody CriarClienteRequestDto dto) {
		// executando o serviço da camada de domínio
		CriarClienteResponseDto response = clienteDomainService.criarCliente(dto);
		// retornar a resposta
		return ResponseEntity.status(201).body(response);
	}

	@PostMapping("autenticar")
	public ResponseEntity<AutenticarClienteResponseDto> autenticar(
			@Valid @RequestBody AutenticarClienteRequestDto dto) {
		// executando o serviço da camada de domínio
		AutenticarClienteResponseDto response = clienteDomainService.autenticarCliente(dto);
		// retornar a resposta
		return ResponseEntity.status(200).body(response);
	}

}