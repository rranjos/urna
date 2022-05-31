package br.com.urna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.urna.modelo.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Integer>{

	List<Candidato> findByEleicaoIdEleicao(Integer idEleicao);

	Candidato findByNumeroCandidato(Integer idCandidato);

	@Query("DELETE from Candidato a where a.eleicao.idEleicao = :idEleicao")
	void deleteByIdEleicao(@Param(value = "idEleicao") Integer idEleicao);

}
