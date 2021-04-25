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
	
	private final String MSG_APOLICE_INEXISTENTE = "CPF já está cadastrado!";
	private final String MSG_CLIENTE_INEXISTENTE = "Cliente não existe!";
	private final String MSG_DATA_FIM_MENOR_DATA_INCIO = "A Data Fim não pode ser Menor que a Data Inicio!";
	private final String MSG_INFORME_CPF = "Por favor, informe o CPF do cliente";
	
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
		return repository.findById(numero).orElseThrow(() -> new ResourceNotAcceptableException(MSG_APOLICE_INEXISTENTE));
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
			throw new ResourceNotAcceptableException(MSG_DATA_FIM_MENOR_DATA_INCIO);
		}
	}

	private Cliente validarCliente(String cpf) {
		if (ObjectUtils.isEmpty(cpf)) {
			throw new ResourceNotAcceptableException(MSG_INFORME_CPF);
		}
		return clienteRepository.findByCpf(cpf)
				.orElseThrow(() -> new ResourceNotAcceptableException(MSG_CLIENTE_INEXISTENTE));
	}
}
