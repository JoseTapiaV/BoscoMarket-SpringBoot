package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Tarjeta;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CrearTarjeta {
    @JsonProperty
    @Getter @Setter
    private String numero;

    @JsonProperty
    @Getter @Setter
    private String nombre;

    @JsonProperty
    @Getter @Setter
    private String fecha;
    @JsonProperty
    @Getter @Setter
    private long cliente;

}
