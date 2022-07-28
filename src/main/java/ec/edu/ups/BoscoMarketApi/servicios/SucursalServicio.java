package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import ec.edu.ups.BoscoMarketApi.repositorios.SucursalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalServicio {
    @Autowired
    private SucursalRepositorio sucursalRepositorio;

    public Sucursal findById(Long id) {
        return sucursalRepositorio.findById(id).orElse(null);
    }

    public List<Sucursal> findAll(){
        return (List<Sucursal>) sucursalRepositorio.findAll();
    }

    public Optional<Sucursal> findByCodigo(Long codigo){
        return (Optional<Sucursal>) sucursalRepositorio.findById(codigo);
    }

    public String latitud(Long id){
        return sucursalRepositorio.latitud(id);
    }

    public String longitud(Long id){
        return sucursalRepositorio.longitud(id);
    }
}
