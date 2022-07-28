package ec.edu.ups.BoscoMarketApi.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason ="Datos no encontrados")
public class DatosNoEncontrado extends RuntimeException{
    public DatosNoEncontrado() {
    }

    public DatosNoEncontrado(String message) {
        super(message);
    }
}
