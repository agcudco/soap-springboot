package ec.edu.espe.springbootsoap.config;

import ec.edu.espe.springbootsoap.model.Categoria;
import ec.edu.espe.springbootsoap.model.Cliente;
import ec.edu.espe.springbootsoap.model.Producto;
import ec.edu.espe.springbootsoap.repository.CategoriaRepository;
import ec.edu.espe.springbootsoap.repository.ClienteRepository;
import ec.edu.espe.springbootsoap.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner cargarDatos(
            CategoriaRepository categoriaRepo,
            ProductoRepository productoRepo,
            ClienteRepository clienteRepo
    ) {
        return args -> {
            // Limpiar tablas para pruebas repetibles
            productoRepo.deleteAll();
            categoriaRepo.deleteAll();
            clienteRepo.deleteAll();

            // Crear categorías
            Categoria catElectro = new Categoria();
            catElectro.setNombre("Electrónica");
            catElectro = categoriaRepo.save(catElectro);

            Categoria catRopa = new Categoria();
            catRopa.setNombre("Ropa");
            catRopa = categoriaRepo.save(catRopa);

            // Crear productos y asociarlos a categorías
            Producto p1 = new Producto();
            p1.setNombre("Smartphone X");
            p1.setPrecio(799.99);
            p1.setCategoria(catElectro);
            productoRepo.save(p1);

            Producto p2 = new Producto();
            p2.setNombre("Laptop Pro");
            p2.setPrecio(1299.50);
            p2.setCategoria(catElectro);
            productoRepo.save(p2);

            Producto p3 = new Producto();
            p3.setNombre("Camiseta Deportiva");
            p3.setPrecio(29.90);
            p3.setCategoria(catRopa);
            productoRepo.save(p3);

            // (Opcional) actualizar la lista de productos en las categorías
            catElectro.setProductos(Arrays.asList(p1, p2));
            catRopa.setProductos(Arrays.asList(p3));
            categoriaRepo.saveAll(Arrays.asList(catElectro, catRopa));

            // Crear clientes de prueba
            Cliente c1 = new Cliente();
            c1.setNombre("María López");
            c1.setEmail("maria.lopez@espe.edu.ec");
            clienteRepo.save(c1);

            Cliente c2 = new Cliente();
            c2.setNombre("Carlos Pérez");
            c2.setEmail("carlos.perez@espe.edu.ec");
            clienteRepo.save(c2);

            System.out.println("Datos de prueba cargados correctamente.");
        };
    }
}
