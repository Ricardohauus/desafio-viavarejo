package br.com.viavarejo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import br.com.viavarejo.error.ResourceNotAcceptableException;
import br.com.viavarejo.model.Apolice;
import br.com.viavarejo.model.Cliente;
import br.com.viavarejo.repository.ApoliceRepository;
import br.com.viavarejo.repository.ClienteRepository;
import br.com.viavarejo.service.ApoliceService;

@Service
public class ApoliceServiceImpl implements ApoliceService {

	@Autowired
	ApoliceRepository repository;

	@Autowired
	ClienteRepository clienteRepository;

	@Override
	public Apolice create(Apolice a) {
		Cliente cliente = validarCliente(a.getCliente().getCpf());
		validarData(a);
		a.setCliente(cliente);
		return repository.save(a);
	}

	@Override
	public Apolice update(Apolice a, String numero) {
		a.setNumero(numero);
		validarData(a);
		validarCliente(a.getCliente().getCpf());
		return repository.save(a);
	}

	@Override
	public Apolice findById(String numero) {
		return repository.findById(numero).orElseThrow(() -> new ResourceNotAcceptableException("Apolice não existe!"));
	}

	@Override
	public List<Apolice> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(String numero) {
		repository.deleteById(numero);
	}

	private void validarData(Apolice a) {
		if (a.getDataFim().isBefore(a.getDataInicio())) {
			throw new ResourceNotAcceptableException("A Data Fim não pode ser Menor que a Data Inicio!");
		}
	}

	private Cliente validarCliente(String cpf) {
		if (ObjectUtils.isEmpty(cpf)) {
			throw new ResourceNotAcceptableException("Por favor, informe um cliente");
		}
		return clienteRepository.findByCpf(cpf)
				.orElseThrow(() -> new ResourceNotAcceptableException("Este Cliente não está cadastrado!"));
	}
}
