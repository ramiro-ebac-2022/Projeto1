
package Dao;


import Domain.Cliente;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Ramiro
 */
public class ClienteMapDao implements IClienteDao{
    private Map<Long, Cliente> map;
	
	public ClienteMapDao() {
		map = new TreeMap<>();
	}
	
	@Override
	public Boolean cadastrar(Cliente cliente) {
		if (this.map.containsKey(cliente.getCpf())) {
			return false;
		}
		
		this.map.put(cliente.getCpf(), cliente);
		return true;
	}

	@Override
	public void excluir(Long cpf) {
		Cliente clienteCadastrado = this.map.get(cpf); 
                if(clienteCadastrado != null) {
                    map.remove(clienteCadastrado.getCpf(), clienteCadastrado);    
                }
		
	}

	@Override
	public void alterar(Cliente cliente) {
		Cliente clienteCadastrado = this.map.get(cliente.getCpf());
                if(clienteCadastrado != null) {
                    clienteCadastrado.setCidade(cliente.getCidade());
                    clienteCadastrado.setEnd(cliente.getEnd());
                    clienteCadastrado.setEstado(cliente.getEstado());
                    clienteCadastrado.setNome(cliente.getNome());
                    clienteCadastrado.setNumero(cliente.getNumero());
                    clienteCadastrado.setTel(cliente.getTel());  
                }
		
	}

	@Override
	public Cliente consultar(Long cpf) {
		return this.map.get(cpf);
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		return this.map.values();
	}
}
