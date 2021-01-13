package br.com.mtakahashi.orangetalents.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mtakahashi.orangetalents.domain.model.Solicitante;
import br.com.mtakahashi.orangetalents.domain.repository.SolicitanteRepository;

@RestController
@RequestMapping("/solicitantes")
public class SolicitanteController {
	
	@Autowired
	private SolicitanteRepository solicitanteRepository;
	
	@GetMapping
	public List<Solicitante> listar() {
		return solicitanteRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitante adicionar(@Valid @RequestBody Solicitante solicitante) {
		return solicitanteRepository.save(solicitante);
	}
	
}
