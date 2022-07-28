package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Categoria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearCategoria {
    @JsonProperty
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
