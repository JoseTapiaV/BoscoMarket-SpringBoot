package ec.edu.ups.BoscoMarketApi.controladores;

import ec.edu.ups.BoscoMarketApi.entidades.Categoria;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Categoria.ActualizarCategoria;
import ec.edu.ups.BoscoMarketApi.entidades.peticiones.Categoria.CrearCategoria;
import ec.edu.ups.BoscoMarketApi.servicios.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class CategoriaControlador {

    private CategoriaServicio categoriaServicio;

    @Autowired
    public void setCategoriaServicio(CategoriaServicio categoriaServicio) {
        this.categoriaServicio = categoriaServicio;
    }
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> getAllCategoria(){
        List<Categoria> listaCat = categoriaServicio.findAll();
        return new ResponseEntity<List<Categoria>>(listaCat, HttpStatus.OK);
    }

    @GetMapping("{id}/nombre")
    public ResponseEntity<String> getNombreById(@PathVariable Long id){
        String nombre = categoriaServicio.retrieveCategoriaNombreById(id);
        return new ResponseEntity<String>(nombre, HttpStatus.OK);
    }
    @PostMapping("categoria/create")
    public ResponseEntity<Categoria> createCategoria(@RequestBody CrearCategoria crearCategoria){
        Categoria categoria = new Categoria();
        categoria.setNombre(crearCategoria.getNombre());
        categoriaServicio.save(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("categoria/eliminar/{id}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Long id){
        categoriaServicio.delete(id);
        return ResponseEntity.ok("ok");
    }

    @PutMapping("categoria/actualizar")
    public ResponseEntity<Categoria> actualizarCategoria(@RequestBody ActualizarCategoria actualizarCategoria){
        Optional<Categoria> categoriaOptional = categoriaServicio.findById(actualizarCategoria.getId());
        if(categoriaOptional.isEmpty()){
            return  ResponseEntity.badRequest().build();
        }
        Categoria categoria =categoriaOptional.get();
        categoria.setNombre(actualizarCategoria.getNombre());
        categoriaServicio.save(categoria);
        return ResponseEntity.ok(categoria);
    }
}
