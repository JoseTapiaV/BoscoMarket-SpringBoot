package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.FacturaCabecera;
import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import ec.edu.ups.BoscoMarketApi.repositorios.FacturaCabeceraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaCabeceraServicio {

    @Autowired
    private FacturaCabeceraRepositorio facturaCabeceraRepositorio;

    public List<FacturaCabecera> findAll(){
        return (List<FacturaCabecera>) facturaCabeceraRepositorio.findAll();
    }

    public void save(FacturaCabecera facturaCabecera){
        facturaCabeceraRepositorio.save(facturaCabecera);
    }

    public FacturaCabecera findById(Long id) {
        return facturaCabeceraRepositorio.findById(id).orElse(null);
    }
}
