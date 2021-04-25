package br.com.viavarejo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viavarejo.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

	Boolean existsByCpf(String cpf);
	
	Boolean existsByCpfAndIdNot(String cpf, String id);
	
	Optional<Cliente> findByCpf(String cpf);
}
