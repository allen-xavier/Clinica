package br.com.dh.lojaonline.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.lojaonline.model.entities.AccountCredentials;

public interface AccountCredentialsRepository extends CrudRepository<AccountCredentials, Integer> {
	AccountCredentials findByUsername(String username);
}
