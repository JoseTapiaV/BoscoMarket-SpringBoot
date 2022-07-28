package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.FacturaCabecera;
import ec.edu.ups.BoscoMarketApi.entidades.FacturaDetalle;
import ec.edu.ups.BoscoMarketApi.repositorios.FacturaCabeceraRepositorio;
import ec.edu.ups.BoscoMarketApi.repositorios.FacturaDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaDetalleServicio {
    @Autowired
    private FacturaDetalleRepositorio facturaDetalleRepositorio;

    public List<FacturaDetalle> findAll(){
        return (List<FacturaDetalle>) facturaDetalleRepositorio.findAll();
    }

    public void save(FacturaDetalle facturaDetalle ){
        facturaDetalleRepositorio.save(facturaDetalle);
    }

    public FacturaDetalle findById(Long id) {return facturaDetalleRepositorio.findById(id).orElse(null);}
}
