package ec.edu.espe.springbootsoap.services.impl;

import ec.edu.espe.springbootsoap.model.Categoria;
import ec.edu.espe.springbootsoap.repository.CategoriaRepository;
import ec.edu.espe.springbootsoap.services.CategoriaService;
import jakarta.jws.WebService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@WebService(
        endpointInterface = "ec.edu.espe.springbootsoap.services.CategoriaService",
        targetNamespace = "http://soap.espe.edu.ec/",
        serviceName = "CategoriaService"
)
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Long id) {
        return repo.findByIdWithProductos(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listCategorias() {
        //return repo.findAllWithProductos();
        List<Categoria> cats = repo.findAll();
        cats.forEach(c -> c.getProductos().size());  // fuerza carga de productos
        return cats;
    }

    @Override
    @Transactional
    public Categoria createCategoria(Categoria categoria) {
        categoria.setId(null);
        return repo.save(categoria);
    }

    @Override
    @Transactional
    public boolean deleteCategoria(Long id) {
        Optional<Categoria> c = repo.findById(id);
        if (c.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
