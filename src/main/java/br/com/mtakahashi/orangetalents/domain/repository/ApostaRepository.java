package br.com.mtakahashi.orangetalents.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtakahashi.orangetalents.domain.model.Aposta;

@Repository
public interface ApostaRepository extends JpaRepository<Aposta, Long> {
	List<Aposta> findBySolicitanteEmail(String email);
	Aposta findByNumerosAndSolicitanteEmail(String numeros, String email);
}
