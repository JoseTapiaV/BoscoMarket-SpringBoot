package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ActualizarPedido {

    @JsonProperty
    @Getter @Setter
    private Long id;

    @JsonProperty
    @Getter @Setter
    private double latitud;

    @JsonProperty
    @Getter @Setter
    private double longitud;

    @JsonProperty
    @Getter @Setter
    private String estado;

    @Getter @Setter
    @JsonProperty
    private int cantidadProducto;

    @JsonProperty
    @Getter @Setter
    private double costoEnvio;

    @JsonProperty
    @Getter @Setter
    private String llegada;

    @JsonProperty
    @Getter @Setter
    private Long idCliente;

    @JsonProperty
    @Getter @Setter
    private Long idSucursal;

    @JsonProperty
    @Getter @Setter
    private Long idFacturaDetalle;

    @JsonProperty
    @Getter @Setter
    private Long idProducto;

    public ActualizarPedido(){
    }
}
