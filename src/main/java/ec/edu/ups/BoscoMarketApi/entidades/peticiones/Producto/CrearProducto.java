package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CrearProducto {

    @JsonProperty
    @Getter @Setter
    private String nombre;

    @JsonProperty
    @Getter @Setter
    private double precio;

    @JsonProperty
    @Getter @Setter
    private int stock;

    @JsonProperty
    @Getter @Setter
    private String descripcion;

    @JsonProperty
    @Getter @Setter
    private Long idSucursal;

    @JsonProperty
    @Getter @Setter
    private Long idCategoria;

    public CrearProducto() {
    }
}
