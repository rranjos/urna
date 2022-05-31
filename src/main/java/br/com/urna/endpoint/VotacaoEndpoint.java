package br.com.urna.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.urna.modelo.Candidato;
import br.com.urna.service.IVotacaoService;

@RestController
@RequestMapping({ "/votacao" })
@CrossOrigin(origins = "*")
public class VotacaoEndpoint {
	
	@Autowired
	private IVotacaoService service;
	
	@PostMapping(path = "/votar")
	public ResponseEntity<Candidato> votar(@RequestBody Candidato candidato) {
		service.votar(candidato);
		return new ResponseEntity<>(candidato, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/apurar/{id}")
	public ResponseEntity<?> apurar(@PathVariable Integer id){
		service.apurar(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}

}
