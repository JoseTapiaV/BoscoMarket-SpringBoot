package ec.edu.ups.BoscoMarketApi.repositorios;

import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.Pedidos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public  interface PedidoRepositorio extends CrudRepository<Pedido, Long> {

    @Query("SELECT p.id FROM Pedido p where p.latitud = :latitud")
    Long obtenerID(Double latitud);

    @Query("SELECT p FROM Pedido p where p.cliente.id = :clienteId")
    List<Pedido> findPedidoByCliente(Long clienteId);
    //select pedido.latitud,pedido.longitud,pedido.estado,pedido.cantidad_producto ,pedido.costo_envio, pedido.llegada from pedido ,producto where pedido.producto_id=producto.id and pedido.cliente_id=:clienteId

    @Query(value = "select * from pedido ,producto where pedido.producto_id=producto.id and pedido.cliente_id=:clienteId",nativeQuery = true)
    List<Pedido> pedidoDetalle(Long clienteId);

}

