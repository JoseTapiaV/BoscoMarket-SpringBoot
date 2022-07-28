package ec.edu.ups.BoscoMarketApi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FacturaDetalle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private int cantidad;
    @Getter @Setter
    private double precio;
    @Getter @Setter
    private String descripcion;
    @Getter @Setter
    private double totalXproducto;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Pedido pedido;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private FacturaCabecera facturaCabecera;

    public FacturaDetalle() {
    }
}
