package br.com.viavarejo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.error.ResourceNotAcceptableException;
import br.com.viavarejo.model.Cliente;
import br.com.viavarejo.repository.ClienteRepository;
import br.com.viavarejo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository repository;

	private final String MSG_CPF_CADASTRADO = "CPF já está cadastrado!";
	private final String MSG_CLIENTE_INEXISTENTE = "Cliente não existe!";

	@Override
	public Cliente create(Cliente c) {
		if (repository.existsByCpf(c.getCpf())) {
			throw new ResourceNotAcceptableException(MSG_CPF_CADASTRADO);
		}
		return repository.save(c);
	}

	@Override
	public Cliente update(Cliente c, String id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotAcceptableException(MSG_CLIENTE_INEXISTENTE);
		}
		if (repository.existsByCpfAndIdNot(c.getCpf(), id)) {
			throw new ResourceNotAcceptableException(MSG_CPF_CADASTRADO);
		}
		c.setId(id);
		return repository.save(c);
	}

	@Override
	public Cliente findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotAcceptableException(MSG_CLIENTE_INEXISTENTE));
	}

	@Override
	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}
}
