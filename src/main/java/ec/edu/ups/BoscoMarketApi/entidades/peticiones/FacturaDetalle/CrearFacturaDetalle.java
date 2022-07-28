package ec.edu.ups.BoscoMarketApi.entidades.peticiones.FacturaDetalle;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ec.edu.ups.BoscoMarketApi.entidades.Pedido;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;

public class CrearFacturaDetalle {
    @JsonProperty
    @Getter @Setter
    private Long id;
    @JsonProperty
    @Getter @Setter
    private int cantidad;
    @JsonProperty
    @Getter @Setter
    private double precio;
    @JsonProperty
    @Getter @Setter
    private String descripcion;
    @JsonProperty
    @Getter @Setter
    private double totalXproducto;
    @JsonProperty
    @Getter @Setter
    private Long  idPedido;
    @JsonProperty
    @Getter @Setter
    private Long  idFacturaCabecera;
}
