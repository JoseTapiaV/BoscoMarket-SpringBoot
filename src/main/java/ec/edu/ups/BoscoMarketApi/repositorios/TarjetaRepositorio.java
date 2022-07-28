package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.PagoTarjeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarjetaRepositorio extends CrudRepository<PagoTarjeta, Long> {
    @Query("select p from PagoTarjeta p where p.cliente.id = :id")
    List<PagoTarjeta> findByClienteId(Long id);
}
