package br.com.urna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.urna.modelo.Candidato;
import br.com.urna.modelo.Eleicao;
import br.com.urna.modelo.Votacao;
import br.com.urna.repository.CandidatoRepository;
import br.com.urna.repository.EleicaoRepository;
import br.com.urna.repository.VotacaoRepository;
import br.com.urna.service.IEleicaoService;

@Service
public class EleicaoServiceImpl implements IEleicaoService{

	@Autowired
	private EleicaoRepository repository;
	
	@Autowired
	private CandidatoRepository repositoryCandidato;
	
	@Autowired
	private VotacaoRepository repositoryVotacao;
	
	@Override
	public List<Eleicao> listarEleicoes() {
		return repository.findAll();
	}

	@Override
	public void salvar(Eleicao eleicao) {
		repository.save(eleicao);
		
	}

	@Override
	public Eleicao recuperarEleicao(Integer id) {
		return repository.findByIdEleicao(id);
	}

	@Override
	public void alterar(Eleicao eleicao) {
		repository.save(eleicao);
		
	}

	@Override
	public void excluir(Integer id) {
		
		List<Candidato> lst = repositoryCandidato.findByEleicaoIdEleicao(id);
		List<Votacao> lstVotacao = repositoryVotacao.findByCandidatoEleicaoIdEleicao(id);
		
		for (Votacao votacao : lstVotacao) {
			repositoryVotacao.delete(votacao);
		}
		
		for (Candidato candidato : lst) {
			repositoryCandidato.delete(candidato);
		}
				
		Eleicao e = new Eleicao();
		e.setIdEleicao(id);
		repository.delete(e);
		
	}

	@Override
	public void apurar(Integer idEleicao) {
		
		List<Votacao> votacao = repositoryVotacao.findByCandidatoEleicaoIdEleicao(idEleicao);
	}

}
