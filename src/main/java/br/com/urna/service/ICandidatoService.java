package br.com.urna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.urna.modelo.Candidato;

@Service
public interface ICandidatoService {

	void salvar(Candidato candidato);

	List<Candidato> listar(Integer idEleicao);

	Candidato get(Integer numeroCandidato);

	Candidato excluir(Integer id);

}
