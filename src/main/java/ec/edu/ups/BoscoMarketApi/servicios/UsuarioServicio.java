package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import ec.edu.ups.BoscoMarketApi.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public void save(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

    public List<Usuario> findAllUsuarios(){
        return (List<Usuario>) usuarioRepositorio.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Optional<Usuario> findByCodigo(Long codigo){
        return (Optional<Usuario>) usuarioRepositorio.findById(codigo);
    }

    public String iniciarSesionCorreo(String correo){
        return usuarioRepositorio.inicioSesionCorreo(correo);
    }

    public String iniciarSesionPassword(String password){
        return usuarioRepositorio.inicioSesionPasword(password);
    }

    public Optional<Usuario> findUsuario(String correo, String password){
        return (Optional<Usuario>) usuarioRepositorio.findUsuario(correo,password);
    }
}
