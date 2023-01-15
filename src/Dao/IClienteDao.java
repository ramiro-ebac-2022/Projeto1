
package Dao;


import Domain.Cliente;
import java.util.Collection;

/**
 *
 * @author Ramiro
 */
public interface IClienteDao {
    	public Boolean cadastrar(Cliente cliente);
	
	public void excluir(Long cpf);
	
	public void alterar(Cliente cliente);
	
	public Cliente consultar(Long cpf);
	
	public Collection<Cliente> buscarTodos();
}
