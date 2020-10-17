package br.com.dh.clinica.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dh.clinica.model.entities.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
	Paciente findOneByCpf(String cpf);
	
	void deleteByCpf(String cpf);
}
