package br.com.viavarejo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viavarejo.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

	Boolean existsByCpf(String cpf);
}
