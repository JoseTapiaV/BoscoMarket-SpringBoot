package ec.edu.ups.BoscoMarketApi.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PagoTarjeta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String numero;
    @Getter @Setter
    private String nombre;
    @Getter @Setter
    private String fecha;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    @JsonIgnore
    private Cliente cliente;

    public PagoTarjeta() {
    }
}
