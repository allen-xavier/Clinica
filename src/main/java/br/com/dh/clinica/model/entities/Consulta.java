package br.com.dh.clinica.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "paciente")
	@JsonIgnoreProperties("consulta")
	private Paciente paciente;
	
	// Serve para cadastrar o cpf do paciente no método post
	// Por ser transiente ele não faz relação com o banco de dados
	private transient String pacienteCpf;
	
	// data como LocalDate
	private LocalDate data;
	// Valor como double
	private Double valor;
	private String descricao;
	
	// Campo Repetido no db
	// private LocalDate dataConsulta;
	

}
