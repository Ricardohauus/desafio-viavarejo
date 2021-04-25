package br.com.viavarejo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.error.ResourceNotAcceptableException;
import br.com.viavarejo.model.Cliente;
import br.com.viavarejo.repository.ApoliceRepository;
import br.com.viavarejo.repository.ClienteRepository;
import br.com.viavarejo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository repository;

	@Autowired
	ApoliceRepository apoliceRepository;

	private final String MSG_CPF_CADASTRADO = "CPF j� est� cadastrado!";
	private final String MSG_CLIENTE_INEXISTENTE = "Cliente n�o existe!";
	private final String MSG_CLIENTE_VINCULADO_APOLICE = "N�o foi possivel excluir este Cliente, pois ele est� vinculado a uma Apolice!";

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
	public Boolean delete(String id) {
		Cliente c = repository.findById(id)
				.orElseThrow(() -> new ResourceNotAcceptableException(MSG_CLIENTE_INEXISTENTE));
		if (apoliceRepository.existsByCliente(c)) {
			throw new ResourceNotAcceptableException(MSG_CLIENTE_VINCULADO_APOLICE);
		}
		repository.deleteById(id);
		return Boolean.TRUE;
	}

}
