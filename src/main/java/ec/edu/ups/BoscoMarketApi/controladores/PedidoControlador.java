package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Cliente;
import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Categoria.ActualizarCategoria;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.ActualizarPedido;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.CrearPedido;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.Pedidos;
import ec.edu.ups.BoscoMarketApi.servicios.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class PedidoControlador{

    //Variables globales
    @Setter
    static int Cant = 0;
    @Setter
    static  double costoenv = 0;
    @Setter
    static Long IDProducto;
    @Setter
    static Long IDCliente;

    @Setter Long IDSucursal;

    @Autowired
    @Setter
    private PedidoServicio pedidoServicio;
    @Autowired
    @Setter
    private SucursalServicio sucursalServicio;
    @Autowired
    @Setter
    private FacturaDetalleServicio facturaDetalleServicio;
    @Autowired
    @Setter
    private ProductoServicio productoServicio;
    @Autowired
    @Setter
    private ClienteServicio clienteServicio;

    @PostMapping("/pedido/create")
    public ResponseEntity<Pedido> createPedido(@RequestBody CrearPedido crearPedido){


        Pedido pedido = new Pedido();
        costoenv = crearPedido.getCostoEnvio();
        pedido.setEstado(crearPedido.getEstado());
        Cant = crearPedido.getCantidadProducto();
        pedido.setCantidadProducto(crearPedido.getCantidadProducto());
        pedido.setLatitud(crearPedido.getLatitud());
        pedido.setLongitud(crearPedido.getLongitud());
        pedido.setCliente(clienteServicio.findById(crearPedido.getIdCliente()));
        IDCliente = crearPedido.getIdCliente();
        pedido.setSucursal(sucursalServicio.findById(crearPedido.getIdSucursal()));
        IDSucursal = crearPedido.getIdSucursal();
        //pedido.setFacturaDetalle(facturaDetalleServicio.findById(crearPedido.getIdFacturaDetalle()))
        pedido.setProducto(productoServicio.findById(crearPedido.getIdProducto()));
        IDProducto = crearPedido.getIdProducto();

        updateStock();

        //Calcular costo del envío
        double latitudSucursal = Double.parseDouble(sucursalServicio.latitud(IDSucursal));
        double longitudSucursal = Double.parseDouble(sucursalServicio.longitud(IDSucursal));
        double latitudPedido = crearPedido.getLatitud();
        double longitudPedido = crearPedido.getLongitud();
        double radio = 6372;

        double dLat = Math.toRadians(latitudPedido - latitudSucursal);
        double dLng = Math.toRadians(longitudPedido - longitudSucursal);
        double sindLat = Math.sin(dLat/2);
        double sindLng = Math.sin(dLng/2);
        double va1 = Math.pow(sindLat,2) + Math.toRadians(Math.cos(latitudSucursal)) * Math.toRadians(Math.cos(latitudPedido)) * Math.pow(sindLng,2);
        double va2 = Math.sqrt(va1);
        double distancia = 2 * radio * Math.asin(va2);
        double distanciaTotal = Math.round(distancia * 100)/100;

        //Cada KM tiene un costo de 0.50 Centavos
        costoenv = (distanciaTotal * 0.5)/1;
        pedido.setCostoEnvio(costoenv);

        //Para estimar el tiempo de llegada del pedido se tiene en cuenta que el pedido va a una velocidad de 45KM/H
        double horas = (distanciaTotal * 1)/45;
        String lllegada = "El tiempo de llegada del pedido es de " +horas+" horas";

        pedido.setLlegada(lllegada);

        pedidoServicio.save(pedido);


        //Lineas para mostrar los datos necesarios
        //System.out.println("LATITUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD "+latitudSucursal);
        //System.out.println("LONGITUUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD "+longitudSucursal);
        //System.out.println("LATITUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD "+latitudPedido);
        //System.out.println("LONGITUUDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD "+longitudPedido);
        //System.out.println("DISTANCIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA "+distanciaTotal+"KM");
        //System.out.println("COSTO ENVIOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO "+costoenv);

        return ResponseEntity.ok(pedido);
    }

    public void updateStock(){
        System.out.println("Entreeeeeeeeeee");
        Producto producto = productoServicio.findById(IDProducto);
        producto.setStock(producto.getStock() - Cant);
        System.out.println("proucogososssdddd " + producto.getStock());
        productoServicio.save(producto);
    }

    @GetMapping("/pedidos")
    public ResponseEntity <List<Pedido>> getAllPedidos(){
        List<Pedido> pedidoList = pedidoServicio.findAll();
        return new ResponseEntity<List<Pedido>>(pedidoList, HttpStatus.OK);
    }
//************************
    @GetMapping("/pedidos/{clienteId}")
    public ResponseEntity<List<Pedidos>> getPedidosByCliente(@PathVariable Long clienteId){
        List<Pedidos> pedidoListCliente = pedidoServicio.finpedidoProducto(clienteId);
        return new ResponseEntity<List<Pedidos>>(pedidoListCliente, HttpStatus.OK);
    }


    @DeleteMapping("pedidos/{id}")
    public ResponseEntity<String> eliminarPedido(@PathVariable Long id){
        pedidoServicio.delete(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("pedidos/{id}")
    public ResponseEntity<Pedido> actualizarPedidos(@RequestBody ActualizarPedido actualizarPedido, @PathVariable Long id){
        Pedido pedido = this.pedidoServicio.findById(id);
        Optional<Cliente> cliente = clienteServicio.findByCodigo(actualizarPedido.getIdCliente());
        if(cliente.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Sucursal> sucursal = sucursalServicio.findByCodigo(actualizarPedido.getIdSucursal());
        if(sucursal.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Optional<Producto> producto = productoServicio.findByCodigo(actualizarPedido.getIdProducto());
        if(producto.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        pedido.setLatitud(actualizarPedido.getLatitud());
        pedido.setLongitud(actualizarPedido.getLongitud());
        pedido.setEstado(actualizarPedido.getEstado());
        pedido.setCantidadProducto(actualizarPedido.getCantidadProducto());
        pedido.setCostoEnvio(actualizarPedido.getCostoEnvio());
        pedido.setCliente(pedido.getCliente());
        pedido.setSucursal(pedido.getSucursal());
        pedido.setProducto(pedido.getProducto());

        //tarjeta.setCliente(cliente.get());

        /*
        pedido.setCliente(clienteServicio.findById(actualizarPedido.getIdCliente()));
        pedido.setSucursal(sucursalServicio.findById(actualizarPedido.getIdSucursal()));
        pedido.setProducto(productoServicio.findById(actualizarPedido.getIdProducto()));*/
        pedidoServicio.save(pedido);
        return ResponseEntity.ok(pedido);
    }

}
