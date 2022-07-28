package ec.edu.ups.BoscoMarketApi.entidades.peticiones.FacturaCabecera;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class CrearFacturaCabecera {

    @JsonProperty
    @Getter @Setter
    private double total;

    @JsonProperty
    @Getter @Setter
    private String fecha;

    @JsonProperty
    @Getter @Setter
    private double subtotal;

    @JsonProperty
    @Getter @Setter
    private double iva;

    @JsonProperty
    @Getter @Setter
    private Long id;

    public CrearFacturaCabecera(){
    }
}
