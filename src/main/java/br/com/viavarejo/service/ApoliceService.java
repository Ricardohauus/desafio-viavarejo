package br.com.viavarejo.service;

import java.util.List;

import br.com.viavarejo.dto.ApoliceDTO;
import br.com.viavarejo.model.Apolice;

public interface ApoliceService {

	/*
	 * Cadastra uma nova Apolice.
	 * 
	 * @param Apolice, A Apolice que ser� criada.
	 * 
	 * @return A Apolice que foi cadastrada.
	 * 
	 */

	public Apolice create(Apolice a);

	/*
	 * Atualiza uma Apolice.
	 * 
	 * @param Apolice, A Apolice que ser� atualizada.
	 * 
	 * @param numero, O numero da Apolice que ser� atualizada.
	 * 
	 * @return A Apolice que foi atualizada.
	 * 
	 */

	public Apolice update(Apolice a, String numero);

	/*
	 * Lista todas as Apolices
	 * 
	 * @return A lista de todas as Apolices.
	 * 
	 */
	public List<Apolice> findAll();

	/*
	 * Exclui uma Apolice pelo Numero
	 * 
	 * @param numero, numero da Apolice que ser� deletada.
	 * 
	 */
	public void delete(String numero);

	/*
	 * Pesquisa Apolice pelo Numero.
	 * 
	 * @param numero, O Numero da Apolice que ser� pesquisada.
	 * 
	 * @return A ApoliceDTO que foi pesquisada.
	 * 
	 */

	public ApoliceDTO findByNumero(String numero);

}
