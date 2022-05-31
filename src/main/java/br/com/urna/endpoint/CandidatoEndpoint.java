package br.com.urna.endpoint;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.urna.modelo.Candidato;
import br.com.urna.service.ICandidatoService;

@RestController	
@RequestMapping({ "/candidato" })
@CrossOrigin(origins = "*")
public class CandidatoEndpoint {
	
	@Autowired
	private ICandidatoService service;
	

	@GetMapping("/listar/{id}")
	public ResponseEntity<?> listar(@PathVariable Integer id) {
		List<Candidato> lst = service.listar(id);
		return new ResponseEntity<>(lst, HttpStatus.OK);
	}
	
	@GetMapping("/listar-ordenado/{id}")
	public ResponseEntity<?> listarOrdenado(@PathVariable Integer id) {
		List<Candidato> lst = service.listar(id);
		List<Candidato> sortedList = lst.stream()
				.sorted(Comparator.comparingInt(Candidato::getVotos)
				.reversed())
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(sortedList, HttpStatus.OK);
	}
	
	@PostMapping(path = "/criar")
	public ResponseEntity<Candidato> criar(@RequestBody Candidato candidato) {
		service.salvar(candidato);
		return new ResponseEntity<>(candidato, HttpStatus.CREATED);
	}
	
	@GetMapping("/{numeroCandidato}")
	public ResponseEntity<Candidato> get(@PathVariable Integer numeroCandidato) {
		Candidato candidato = service.get(numeroCandidato);
		return new ResponseEntity<>(candidato, HttpStatus.CREATED);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Candidato> excluir(@PathVariable Integer id) {
		Candidato candidato = service.excluir(id);
		return new ResponseEntity<>(candidato, HttpStatus.CREATED);
	}
}
