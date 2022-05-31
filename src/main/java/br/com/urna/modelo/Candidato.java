package br.com.urna.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Entity
public class Candidato implements Serializable{

	private static final long serialVersionUID = 1927086879215197383L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidato", nullable = false)
	private Integer idCandidato;
	
	@Column(name = "nm_candidato")
	private String nomeCandidato;
	
	@Column(name = "foto")
	private String foto;
	
	@Column(name = "nr_candidato")
	private Integer numeroCandidato;
	
	@ManyToOne
    @JoinColumn(name="id_eleicao", referencedColumnName="id_eleicao")
	private Eleicao eleicao;
	
	@Column(name = "votos")
	private Integer votos;
	

}
