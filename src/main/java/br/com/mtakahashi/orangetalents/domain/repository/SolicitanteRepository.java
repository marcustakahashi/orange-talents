package br.com.mtakahashi.orangetalents.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mtakahashi.orangetalents.domain.model.Solicitante;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, Long>{
	Solicitante findByEmail(String email);
}
