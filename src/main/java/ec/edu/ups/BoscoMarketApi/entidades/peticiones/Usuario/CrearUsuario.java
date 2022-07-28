package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Usuario;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class CrearUsuario {
    @JsonProperty
    @Getter @Setter
    private String correo;
    @JsonProperty
    @Getter @Setter
    private String password;
    @JsonProperty
    @Getter @Setter
    private String rol;
    @JsonProperty
    @Getter @Setter
    private long cliente;

    public CrearUsuario() {
    }
}
