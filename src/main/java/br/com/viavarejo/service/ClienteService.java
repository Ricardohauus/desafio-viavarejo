package br.com.viavarejo.service;

import java.util.List;

import br.com.viavarejo.model.Cliente;

public interface ClienteService {

	/*
	 * Cadastra um novo Cliente.
	 * 
	 * @param Cliente, O Cliente que será criado.
	 * 
	 * @return O Cliente que foi cadastrado.
	 * 
	 * @throws Se existir um Cliente com o mesmo CPF retorna uma mensagem de erro.
	 * 
	 */

	public Cliente create(Cliente c);

	/*
	 * Atualiza um Cliente.
	 * 
	 * @param Cliente, O Cliente que será atualizado.
	 * 
	 * @param id, O ID da Apolice que será atualizada.
	 * 
	 * @return O Cliente que foi atualizado.
	 * 
	 * @throws Se existir um Cliente com o mesmo CPF retorna uma mensagem de erro.
	 * 
	 */

	public Cliente update(Cliente c, String id);

	/*
	 * Pesquisa Cliente pelo ID.
	 * 
	 * @param id, O ID Cliente que será pesquisado.
	 * 
	 * @return O Cliente que foi pesquisado.
	 * 
	 */

	public Cliente findById(String id);

	/*
	 * Lista todos os Clientes
	 * 
	 * @return A lista de todos os médicos.
	 * 
	 */
	public List<Cliente> findAll();

	/*
	 * Exclui um Cliente pelo ID
	 * 
	 * @param ID, Identificador do Cliente que será deletado.
	 * 
	 */
	public void delete(String id);

}
