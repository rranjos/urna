package br.com.urna.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Eleicao implements Serializable{

	private static final long serialVersionUID = -1007951089694034839L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_eleicao", nullable = false)
	private Integer idEleicao;
	
	@Column(name = "nm_eleicao")
	private String nmEleicao;
	

}
