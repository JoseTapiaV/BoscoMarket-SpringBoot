package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import ec.edu.ups.BoscoMarketApi.entidades.Producto;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido.Pedidos;
import ec.edu.ups.BoscoMarketApi.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    //Guaradar pedido
    public void save(Pedido pedido){
        pedidoRepositorio.save(pedido);
    }/*
    public void actualizaCantidad(Pedido pedido, Long id){
        pedidoRepositorio.actualizarStock(id);
    }*/


    //Actualizar  Pedido
    /*
    public Optional<Pedido> findById(long id){
        return (Optional<Pedido>)  pedidoRepositorio.findById(id);
    }*/
    public Pedido findById(Long id){ return pedidoRepositorio.findById(id).orElse(null);
    }

    public List<Pedido> findAll(){
        return (List<Pedido>) pedidoRepositorio.findAll();
    }

    public void delete(Long id){
        pedidoRepositorio.deleteById(id);
    }
    public Optional<Pedido> findByCodigo(Long codigo){
        return (Optional<Pedido>) pedidoRepositorio.findById(codigo);
    }

    public Long obtenerID(Double latitud){
        return pedidoRepositorio.obtenerID(latitud);
    }
    /*
    public List<Pedido> findPedidoByCliente(Long codigo){
        return (List<Pedido>) pedidoRepositorio.findPedidoByCliente(codigo);
    }

    public List<Object> finpedidoProducto(Long codigo){
        return (List<Object>) pedidoRepositorio.pedidoProducto(codigo);
    }*/

    public List<Pedidos> finpedidoProducto(Long codigo){
        List<Pedidos> pedidos= new ArrayList<>();
        List<Pedido> pe = pedidoRepositorio.pedidoDetalle(codigo);
        for (int i =0;i<pe.size();i++){
            Pedidos p= new Pedidos();
            p.setCantidadProducto(pe.get(i).getCantidadProducto());
            p.setCostoEnvio(pe.get(i).getCostoEnvio());
            p.setEstado(pe.get(i).getEstado());
            p.setLatitud(pe.get(i).getLatitud());
            p.setNombreProducto(pe.get(i).getProducto().getNombre());
            p.setLlegada(pe.get(i).getLlegada());
            p.setLongitud(pe.get(i).getLongitud());
            p.setIdPedido(pe.get(i).getId());
            pedidos.add(p);

        }

        return pedidos;

    }


}
