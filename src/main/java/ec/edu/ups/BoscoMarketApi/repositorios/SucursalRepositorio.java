package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SucursalRepositorio extends CrudRepository<Sucursal, Long> {
    @Query("SELECT p.latitud FROM Sucursal p WHERE p.id = :id")
    String latitud(Long id);

    @Query("SELECT p.altitud FROM Sucursal p WHERE p.id = :id")
    String longitud(Long id);
}
