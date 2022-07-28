package ec.edu.ups.BoscoMarketApi.servicios;

import ec.edu.ups.BoscoMarketApi.entidades.Categoria;
import ec.edu.ups.BoscoMarketApi.entidades.Sucursal;
import ec.edu.ups.BoscoMarketApi.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    //Listar Categorías
    public List<Categoria> findAll(){
        return (List<Categoria>)categoriaRepositorio.findAll();
    }

    //Devuelve el nombre de la categoría por código
    public String retrieveCategoriaNombreById(Long id){
        return (String) categoriaRepositorio.findCategoriaNombreById(id);
    }
    //Guaradar Categoría
    public void save(Categoria categoria){
        categoriaRepositorio.save(categoria);
    }

    //Eliminar Categoría
    public void delete(Long id){
        categoriaRepositorio.deleteById(id);
    }

    //Actualizar  Categoría
    public Optional<Categoria> findById(long id){
        return (Optional<Categoria>)  categoriaRepositorio.findById(id);
    }

    public Categoria findCategoria(Long id) {
        return categoriaRepositorio.findById(id).orElse(null);
    }

    public Categoria findCategoriaProductoByNombre(String nombre){
        return (Categoria) categoriaRepositorio.findCategoriaProductoByNombre(nombre);
    }
}
