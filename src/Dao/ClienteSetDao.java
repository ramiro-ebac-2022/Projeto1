
package Dao;


import Domain.Cliente;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ramiro
 */
public class ClienteSetDao implements IClienteDao{

    private Set<Cliente> set;
    
    public ClienteSetDao() {
        this.set = new HashSet<>();
    }
    
    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            return false;
        }
        this.set.add(cliente);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteEncontrado = null;
        for (Cliente cliente:this.set) {
                if (cliente.getCpf().equals(cpf)) {
                        clienteEncontrado = cliente;
                        break;
                }
        }

        if (clienteEncontrado != null) {
                this.set.remove(clienteEncontrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        if (this.set.contains(cliente)) {
            for (Cliente clienteCadastrado : this.set) {
                    if (clienteCadastrado.equals(cliente)) {
                            clienteCadastrado.setCidade(cliente.getCidade());
                            clienteCadastrado.setEnd(cliente.getEnd());
                            clienteCadastrado.setEstado(cliente.getEstado());
                            clienteCadastrado.setNome(cliente.getNome());
                            clienteCadastrado.setNumero(cliente.getNumero());
                            clienteCadastrado.setTel(cliente.getTel());
                            break;
                    }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteCadastrado : this.set) {
            if (clienteCadastrado.getCpf().equals(cpf)) {
                    return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }
    
}
