package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.FacturaDetalle;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.FacturaDetalle.CrearFacturaDetalle;
import ec.edu.ups.BoscoMarketApi.servicios.FacturaCabeceraServicio;
import ec.edu.ups.BoscoMarketApi.servicios.FacturaDetalleServicio;
import ec.edu.ups.BoscoMarketApi.servicios.PedidoServicio;
import ec.edu.ups.BoscoMarketApi.servicios.ProductoServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ec.edu.ups.BoscoMarketApi.controladores.PedidoControlador.Cant;
import static ec.edu.ups.BoscoMarketApi.controladores.PedidoControlador.IDProducto;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class FacturaDetalleControlador {
    @Autowired
    @Setter
    private FacturaDetalleServicio facturaDetalleServicio;
    @Autowired
    @Setter
    private PedidoServicio pedidoServicio;

    @Autowired
    @Setter
    private ProductoServicio productoServicio;

    @Autowired
    @Setter
    private FacturaCabeceraServicio facturaCabeceraServicio;

    @PostMapping("/facturaDetalle/create")
    public ResponseEntity<FacturaDetalle> createFacturaDetalle(@RequestBody CrearFacturaDetalle crearFacturaDetalle){

        double precioUint = productoServicio.precioById(IDProducto);

        FacturaDetalle  facturaDetalle = new FacturaDetalle();
        facturaDetalle.setCantidad(Cant);
        facturaDetalle.setPrecio(precioUint);
        facturaDetalle.setDescripcion(crearFacturaDetalle.getDescripcion());
        facturaDetalle.setTotalXproducto(Cant * precioUint);
        facturaDetalle.setPedido(pedidoServicio.findById(crearFacturaDetalle.getIdPedido()));
        facturaDetalle.setFacturaCabecera(facturaCabeceraServicio.findById(crearFacturaDetalle.getIdFacturaCabecera()));
        facturaDetalleServicio.save(facturaDetalle);
        return ResponseEntity.ok(facturaDetalle);
    }

    @GetMapping("/lista")
    public ResponseEntity <List<FacturaDetalle>> getAllPedidos(){
        List<FacturaDetalle> facDet = facturaDetalleServicio.findAll();
        return new ResponseEntity<List<FacturaDetalle>>(facDet, HttpStatus.OK);
    }
}
