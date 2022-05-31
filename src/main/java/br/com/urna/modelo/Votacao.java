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

@Entity(name = "votacao")
@Data
@Getter@Setter
public class Votacao implements Serializable{
	
	private static final long serialVersionUID = 2068743331436973929L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_votacao", nullable = false)
	public Integer id_votacao;
	
	@ManyToOne
    @JoinColumn(name="id_candidato", referencedColumnName="id_candidato")
	public Candidato candidato;

}
