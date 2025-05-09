package ec.edu.espe.springbootsoap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categorias")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    /**
     * Identificador único de la categoría
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre descriptivo de la categoría
     */
    private String nombre;

    /**
     * Lista de productos asociados a esta categoría.
     * Mapeado unidireccional @OneToMany.
     */
    @XmlTransient
    @ToString.Exclude
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Producto> productos;
}
