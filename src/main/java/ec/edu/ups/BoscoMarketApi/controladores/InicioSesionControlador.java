package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Usuario.CrearUsuario;
import ec.edu.ups.BoscoMarketApi.servicios.UsuarioServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = { "*" })
@RestController
public class InicioSesionControlador {

    @Autowired
    @Setter
    private UsuarioServicio usuarioServicio;

    @PostMapping("/login")
    public ResponseEntity<Usuario> inicioSesion(@RequestBody CrearUsuario usuario) {
        Optional<Usuario> usu = usuarioServicio.findUsuario(usuario.getCorreo(), usuario.getPassword());
        if (usu.isEmpty()) {
            return  new ResponseEntity(usu, HttpStatus.BAD_REQUEST);
        }
            return  new ResponseEntity(usu.get().getCliente().getId(),  HttpStatus.OK);
    }
}
