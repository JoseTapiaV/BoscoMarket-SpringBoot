package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    @Query("SELECT p.correo FROM Usuario p where p.correo = :correo")
    String inicioSesionCorreo(String correo);

    @Query("SELECT p.password FROM Usuario p where p.password = :password")
    String inicioSesionPasword(String password);

    @Query("SELECT p FROM Usuario p where p.correo = :correo and p.password = :password")
    Optional<Usuario> findUsuario(String correo, String password);
}
