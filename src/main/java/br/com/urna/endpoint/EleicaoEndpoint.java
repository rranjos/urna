package br.com.urna.endpoint;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.urna.modelo.Eleicao;
import br.com.urna.service.IEleicaoService;

@RestController
@RequestMapping({ "/eleicao" })
@CrossOrigin(origins = "*")
public class EleicaoEndpoint implements Serializable{

	private static final long serialVersionUID = -7378095804100063045L;
	
	@Autowired
	private IEleicaoService service;
	
	@GetMapping(value="/listar")
	public ResponseEntity<?> listar() {
		List<Eleicao> lst = service.listarEleicoes();
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}
	
	@PostMapping(path = "/criar")
	public ResponseEntity<Eleicao> criar(@RequestBody Eleicao eleicao) {
		service.salvar(eleicao);
		return new ResponseEntity<>(eleicao, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Integer id) {
		Eleicao eleicao = service.recuperarEleicao(id);
		return new ResponseEntity<>(eleicao, HttpStatus.OK);
	}
	
	@PutMapping(path = "/alterar")
	public ResponseEntity<?> alterar(@RequestBody Eleicao eleicao) {
		service.alterar(eleicao);
		return new ResponseEntity<>(eleicao, HttpStatus.OK);
	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		service.excluir(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	

}
