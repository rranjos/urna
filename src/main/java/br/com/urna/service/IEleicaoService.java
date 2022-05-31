package br.com.urna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.urna.modelo.Eleicao;

@Service
public interface IEleicaoService {

	List<Eleicao> listarEleicoes();

	void salvar(Eleicao eleicao);

	Eleicao recuperarEleicao(Integer id);

	void alterar(Eleicao eleicao);

	void excluir(Integer id);

	void apurar(Integer idEleicao);

}
