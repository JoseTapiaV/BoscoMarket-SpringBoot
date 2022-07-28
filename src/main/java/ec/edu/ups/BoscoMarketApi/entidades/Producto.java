package ec.edu.ups.BoscoMarketApi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private double precio;
    @Getter @Setter
    private int stock;
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
    private String imagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @Getter @Setter
    private Sucursal sucursal;

    @OneToOne
    @JsonIgnore
    @Getter @Setter
    private Categoria categoria;

    public Producto() {
    }

}
