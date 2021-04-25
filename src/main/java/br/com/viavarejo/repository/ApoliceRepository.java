package br.com.viavarejo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.viavarejo.model.Apolice;
import br.com.viavarejo.model.Cliente;

@Repository
public interface ApoliceRepository extends MongoRepository<Apolice, String> {

	Boolean existsByCliente(Cliente c);

}
