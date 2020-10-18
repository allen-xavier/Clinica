package br.com.dh.clinica.model.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
	@Id
	private String cpf;
	private String nome;
	private String endereco;
	private LocalDate dataNascimento;
	private String telefone;
	private LocalDate dataPrimeiraConsulta;
	private String email;
	private int peso;
	private int altura;
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("paciente")
	private List<Consulta> consultas;
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = LocalDate.parse(dataNascimento);
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setDataPrimeiraConsulta(String dataPrimeiraConsulta) {
		this.dataPrimeiraConsulta = LocalDate.parse(dataPrimeiraConsulta);
	}
	
	public void setDataPrimeiraConsulta(LocalDate dataPrimeiraConsulta) {
		this.dataPrimeiraConsulta = dataPrimeiraConsulta;
	}

}
