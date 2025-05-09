package ec.edu.espe.springbootsoap.repository;

import ec.edu.espe.springbootsoap.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
