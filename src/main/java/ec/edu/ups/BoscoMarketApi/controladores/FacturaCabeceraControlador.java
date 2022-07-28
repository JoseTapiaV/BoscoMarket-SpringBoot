package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.FacturaCabecera;
import ec.edu.ups.BoscoMarketApi.servicios.ClienteServicio;
import ec.edu.ups.BoscoMarketApi.servicios.FacturaCabeceraServicio;
import ec.edu.ups.BoscoMarketApi.servicios.ProductoServicio;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static ec.edu.ups.BoscoMarketApi.controladores.PedidoControlador.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class FacturaCabeceraControlador {
    @Autowired
    @Setter
    private FacturaCabeceraServicio facturaCabeceraServicio;

    @Autowired
    @Setter
    private ClienteServicio clienteServicio;

    @Autowired
    @Setter
    private ProductoServicio productoServicio;


    @GetMapping("/FactCab/create")
    public ResponseEntity<FacturaCabecera> createFacturaCabecera(){
        //Variables de la factura cabecerra
        LocalDateTime fecha = LocalDateTime.now();
        String fechaAct = String.format("%1$tY-%1$tm-%1$td", fecha);

        //Calculos
        double precioUint = productoServicio.precioById(IDProducto);
        double Iva = 0.12;
        double Subtotal = Cant * precioUint;
        double Total = ( Subtotal * Iva) + Subtotal + costoenv;

        FacturaCabecera facturaCabecera = new FacturaCabecera();
        facturaCabecera.setFecha(fechaAct);
        facturaCabecera.setIva(Iva);
        facturaCabecera.setSubtotal(Subtotal);
        facturaCabecera.setTotal(Total);

        facturaCabecera.setCliente(clienteServicio.findById(IDCliente));
        facturaCabeceraServicio.save(facturaCabecera);
        return ResponseEntity.ok(facturaCabecera);
    }
}
