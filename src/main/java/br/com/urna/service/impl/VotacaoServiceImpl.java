package br.com.urna.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.urna.modelo.Candidato;
import br.com.urna.modelo.Votacao;
import br.com.urna.repository.CandidatoRepository;
import br.com.urna.repository.VotacaoRepository;
import br.com.urna.service.IVotacaoService;

@Service
public class VotacaoServiceImpl implements IVotacaoService{

	@Autowired
	private VotacaoRepository repository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Override
	public List<Votacao> listar() {
		return repository.findAll();
	}

	@Override
	public void salvar(Votacao votacao) {
		repository.save(votacao);
	}

	@Override
	public void votar(Candidato candidato) {
		Votacao v = new Votacao();
		v.setCandidato(candidato);
		repository.save(v);
	}

	@Override
	public List<Candidato> apurar(Integer idEleicao) {
		List<Votacao> votos = repository.findByCandidatoEleicaoIdEleicao(idEleicao);
		
		Map<Integer, List<Votacao>> mapa = new HashMap<Integer, List<Votacao>>();
		
		for (Votacao votacao : votos) {
			if(!mapa.containsKey(votacao.getCandidato().getIdCandidato())) {
				mapa.put(votacao.getCandidato().getIdCandidato(), new ArrayList<Votacao>());
			}
			List<Votacao> vs = mapa.get(votacao.getCandidato().getIdCandidato());
			vs.add(votacao);
			
			mapa.put(votacao.getCandidato().getIdCandidato(), vs);
			
		}
		
		List<Candidato> listaCandidatosComVotos = candidatoRepository.findByEleicaoIdEleicao(idEleicao);
		
		for (Candidato candidato : listaCandidatosComVotos) {
			Integer votosDele = mapa.get(candidato.getIdCandidato()).size();
			candidato.setVotos(votosDele);
			candidatoRepository.save(candidato);
		}
		
		return null;
	}
	
	

}
