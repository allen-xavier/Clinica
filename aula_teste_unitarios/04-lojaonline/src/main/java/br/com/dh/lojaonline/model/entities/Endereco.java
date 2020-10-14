package br.com.dh.lojaonline.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int endereco_id;
	
	/* numero, rua bairro, cidade, estado, fk_cliente */
	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	@JsonIgnoreProperties("endereco")
	private Cliente cliente;
	
	@Transient
	private int id_cliente;

	public Endereco() {}

	public Endereco(int endereco_id, String numero, String rua, String bairro,
			String cidade, String estado) {
		this.endereco_id = endereco_id;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public int getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(int endereco_id) {
		this.endereco_id = endereco_id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

}
