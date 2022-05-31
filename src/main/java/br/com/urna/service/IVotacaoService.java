package br.com.urna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.urna.modelo.Candidato;
import br.com.urna.modelo.Votacao;

@Service
public interface IVotacaoService {
	
	public List<Votacao> listar();
	public void salvar(Votacao votacao) ;
	public void votar(Candidato candidato);
	public List<Candidato> apurar(Integer idEleicao);

}
