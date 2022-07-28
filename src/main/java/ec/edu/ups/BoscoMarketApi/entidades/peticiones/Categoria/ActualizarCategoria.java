package ec.edu.ups.BoscoMarketApi.entidades.peticiones.Categoria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActualizarCategoria {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String nombre;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
