package br.com.urna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.urna.modelo.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Integer>{

	List<Votacao> findByCandidatoEleicaoIdEleicao(Integer idEleicao);

}
