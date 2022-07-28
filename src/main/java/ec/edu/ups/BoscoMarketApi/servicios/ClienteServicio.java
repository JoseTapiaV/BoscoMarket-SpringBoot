package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public void save(Cliente cliente){
        clienteRepositorio.save(cliente);
    }

    public List<Cliente> findAllClientes(){
        return (List<Cliente>) clienteRepositorio.findAll();
    }

    public Cliente findById(Long id){
        return clienteRepositorio.findById(id).orElse(null);
    }

    public Optional<Cliente> findByCodigo(Long codigo){
        return (Optional<Cliente>) clienteRepositorio.findById(codigo);
    }

    public void delete(Cliente pesona) {
        clienteRepositorio.delete(pesona);

    }
}
