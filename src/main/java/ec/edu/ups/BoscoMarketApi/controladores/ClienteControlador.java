package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Cliente.CrearCliente;
import ec.edu.ups.BoscoMarketApi.servicios.ClienteServicio;
import ec.edu.ups.BoscoMarketApi.servicios.UsuarioServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class ClienteControlador {
    @Autowired
    @Setter
    private ClienteServicio clienteServicio;

    @Autowired
    @Setter
    private UsuarioServicio usuarioServicio;

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> createCliente(@RequestBody CrearCliente crearCliente){

        Cliente cliente = new Cliente();
        cliente.setNombre(crearCliente.getNombre());
        cliente.setCedula(crearCliente.getCedula());
        cliente.setApellido(crearCliente.getApellido());
        cliente.setTelefono(crearCliente.getTelefono());
        cliente.setCorreo(crearCliente.getCorreo());
        cliente.setDireccion(crearCliente.getDireccion());
        clienteServicio.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/clientes")
    public ResponseEntity <List<Cliente>> getAllClientes(){
        List<Cliente> ClienteList = clienteServicio.findAllClientes();
        return new ResponseEntity<List<Cliente>>(ClienteList, HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    public Cliente show(@PathVariable Long id) {
        return this.clienteServicio.findById(id);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Cliente> update(@RequestBody CrearCliente crearCliente, @PathVariable Long id) {
        Cliente cliente = this.clienteServicio.findById(id);
        cliente.setNombre(crearCliente.getNombre());
        cliente.setCedula(crearCliente.getCedula());
        cliente.setApellido(crearCliente.getApellido());
        cliente.setTelefono(crearCliente.getTelefono());
        cliente.setCorreo(crearCliente.getCorreo());
        this.clienteServicio.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Cliente cliente = this.clienteServicio.findById(id);
        this.clienteServicio.delete(cliente);
    }

}
