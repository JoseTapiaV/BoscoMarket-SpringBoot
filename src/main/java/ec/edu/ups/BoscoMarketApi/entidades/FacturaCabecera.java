package ec.edu.ups.BoscoMarketApi.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FacturaCabecera implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private double total;
    @Getter @Setter
    private String fecha;
    @Getter @Setter
    private double subtotal;
    @Getter @Setter
    private double iva;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    private Cliente cliente;

    public FacturaCabecera(){
    }

    public FacturaCabecera(Long id, double total, String fecha, double subtotal, double iva, Cliente cliente) {
        this.id = id;
        this.total = total;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.cliente = cliente;
    }
}
