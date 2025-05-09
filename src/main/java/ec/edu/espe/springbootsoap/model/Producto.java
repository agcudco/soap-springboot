package ec.edu.espe.springbootsoap.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.*;

@Entity
@Table(name = "productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    /**
     * Identificador único del producto
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del producto
     */
    private String nombre;

    /**
     * Precio en moneda local
     */
    private Double precio;

    /**
     * Relación Many-to-One con categoría.
     * Cada producto pertenece a una única categoría.
     */
    @XmlTransient
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
