package ec.edu.espe.springbootsoap.services.impl;

import ec.edu.espe.springbootsoap.model.Producto;
import ec.edu.espe.springbootsoap.repository.ProductoRepository;
import ec.edu.espe.springbootsoap.services.ProductoService;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@WebService(
        endpointInterface = "ec.edu.espe.springbootsoap.services.ProductoService",
        targetNamespace = "http://soap.espe.edu.ec/",
        serviceName = "ProductoService"
)
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository repo;

    @Override
    public Producto getProducto(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)           // abre sesión Hibernate durante todo el método
    public List<Producto> listProductos() {
        List<Producto> productos = repo.findAll();
        // forzamos carga de la categoría para evitar LazyInitializationException
        productos.forEach(p -> p.getCategoria().getNombre());
        return productos;
    }

    @Override
    public Producto createProducto(Producto producto) {
        producto.setId(null);
        return repo.save(producto);
    }

    @Override
    public boolean deleteProducto(Long id) {
        Optional<Producto> p = repo.findById(id);
        if (p.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
