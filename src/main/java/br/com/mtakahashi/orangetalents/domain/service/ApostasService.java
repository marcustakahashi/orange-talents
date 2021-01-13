package br.com.mtakahashi.orangetalents.domain.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mtakahashi.orangetalents.domain.model.Aposta;
import br.com.mtakahashi.orangetalents.domain.model.Solicitante;
import br.com.mtakahashi.orangetalents.domain.repository.ApostaRepository;
import br.com.mtakahashi.orangetalents.domain.repository.SolicitanteRepository;

@Service
public class ApostasService {

	@Autowired
	private SolicitanteRepository solicitanteRepository;

	@Autowired
	private ApostaRepository apostaRepository;
	
	public List<Aposta> buscarPorEmail(String email) {
		/*var solicitante = solicitanteRepository.findByEmail(email);
		if (solicitante == null) {
			throw new DomainException("Não existe um cliente cadastrado com este e-mail.");
		}*/
		return apostaRepository.findBySolicitanteEmail(email);
	}

	public Aposta criar(String email) {
		var aposta = new Aposta();
		var solicitante = solicitanteRepository.findByEmail(email);
		if (solicitante == null) {
			solicitante = new Solicitante();
			solicitante.setEmail(email);
			solicitante = solicitanteRepository.save(solicitante);
		}
		aposta.setSolicitante(solicitante);
		aposta.setDataHora(LocalDateTime.now());
		aposta.setNumeros(gerarAposta(email));
		
		aposta = apostaRepository.save(aposta);
		return aposta;
	}

	private String gerarAposta(String email) {
		String aposta = "";
		var numeros = new ArrayList<Integer>();
		for (int i = 0; i < 60; i++) {
			numeros.add(i + 1);
		}
		Collections.shuffle(numeros);
		var numerosReduzidos = new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {
			numerosReduzidos.add(numeros.get(i));
		}
		Collections.sort(numerosReduzidos);
		for (int i = 0; i < 6; i++) {
			aposta += " " + String.format("%02d", numerosReduzidos.get(i));
		}
		String resp = aposta.trim();
		if (isRepetido(resp, email)) {
			resp = gerarAposta(email);
		}
		return resp;
	}
	
	private boolean isRepetido(String numeros, String email) {
		Aposta aposta = apostaRepository.findByNumerosAndSolicitanteEmail(numeros, email);
		if (aposta == null) {
			return false;
		}
		return true;
	}
	
}
