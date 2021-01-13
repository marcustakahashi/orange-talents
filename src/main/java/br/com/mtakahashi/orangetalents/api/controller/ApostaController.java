package br.com.mtakahashi.orangetalents.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtakahashi.orangetalents.domain.model.Aposta;
import br.com.mtakahashi.orangetalents.domain.model.CriarApostaInput;
import br.com.mtakahashi.orangetalents.domain.service.ApostasService;

@RestController
@RequestMapping("/apostas")
public class ApostaController {
	
	@Autowired
	private ApostasService apostasService;
	
	@GetMapping("/{clienteEmail}")
	public ResponseEntity<List<Aposta>> buscarPorEmail(@PathVariable String clienteEmail) {
		List<Aposta> apostas = apostasService.buscarPorEmail(clienteEmail);
		
		if (apostas != null && !apostas.isEmpty()) {
			return ResponseEntity.ok(apostas);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aposta criar(@RequestBody CriarApostaInput criarApostaInput) {
		return apostasService.criar(criarApostaInput.getEmail());
	}
	
}
