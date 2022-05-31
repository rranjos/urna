package br.com.urna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.urna.modelo.Eleicao;

@Repository
public interface EleicaoRepository extends JpaRepository<Eleicao, Integer>{

	Eleicao findByIdEleicao(Integer id);

}
