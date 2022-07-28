package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Usuario.CrearUsuario;
import ec.edu.ups.BoscoMarketApi.servicios.ClienteServicio;
import ec.edu.ups.BoscoMarketApi.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class UsuarioControlador {
    @Autowired
    @Setter
    private UsuarioServicio usuarioServicio;

    @Autowired
    @Setter @Getter
    private ClienteServicio clienteServicio;

    @PostMapping("/usuario/create")
    public ResponseEntity<Usuario> createUsuario(@RequestBody CrearUsuario crearUsuario){

        Optional<Cliente> cliente = clienteServicio.findByCodigo(crearUsuario.getCliente());
        if(cliente.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Usuario usuario = new Usuario();
        usuario.setCorreo(crearUsuario.getCorreo());
        usuario.setPassword(crearUsuario.getPassword());
        usuario.setRol(crearUsuario.getRol());
        usuario.setCliente(cliente.get());

        usuarioServicio.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/usuario/edit/{id}")
    public ResponseEntity <Usuario> update(@RequestBody CrearUsuario crearUsuario, @PathVariable Long id) {
        Usuario usuario = this.usuarioServicio.findById(id);
        usuario.setCorreo(crearUsuario.getCorreo());
        usuario.setPassword(crearUsuario.getPassword());
        this.usuarioServicio.save(usuario);
        return ResponseEntity.ok(usuario);
    }



}
