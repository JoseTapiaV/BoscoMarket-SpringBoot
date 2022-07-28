package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import ec.edu.ups.BoscoMarketApi.servicios.SucursalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class SucursalControlador {

    private SucursalServicio sucursalServicio;

    @Autowired
    public void setSucursalServicio(SucursalServicio sucursalServicio) {
        this.sucursalServicio = sucursalServicio;
    }


    @GetMapping("/sucursales")
    public ResponseEntity<List<Sucursal>> getAllSucursales(){
        List<Sucursal> sucursalList = sucursalServicio.findAll();
        return  new ResponseEntity<List<Sucursal>>(sucursalList, HttpStatus.OK);
    }

}
