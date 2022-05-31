package br.com.urna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.urna.modelo.Candidato;
import br.com.urna.repository.CandidatoRepository;
import br.com.urna.service.ICandidatoService;

@Service
public class CandidatoServiceImpl implements ICandidatoService{

	@Autowired
	private CandidatoRepository repository;
	@Override
	public void salvar(Candidato candidato) {
		repository.save(candidato);
	}
	
	@Override
	public List<Candidato> listar(Integer idEleicao) {
		return repository.findByEleicaoIdEleicao(idEleicao);
	}

	@Override
	public Candidato get(Integer numeroCandidato) {
		return repository.findByNumeroCandidato(numeroCandidato);
	}

	@Override
	public Candidato excluir(Integer id) {
		Candidato c = new Candidato();
		c.setIdCandidato(id);
		repository.delete(c);;
		return null;
	}

}
