package ec.edu.espe.springbootsoap.repository;

import ec.edu.espe.springbootsoap.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    /**
     * Busca una categoría junto con su lista de productos, en un solo SELECT.
     */
    @Query("SELECT c FROM Categoria c LEFT JOIN FETCH c.productos WHERE c.id = :id")
    Optional<Categoria> findByIdWithProductos(@Param("id") Long id);

    /**
     * Lista todas las categorías y precarga sus colecciones de productos.
     */
    @Query("SELECT DISTINCT c FROM Categoria c LEFT JOIN FETCH c.productos")
    List<Categoria> findAllWithProductos();
}
