package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idCategoria;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "prenda_categoria",
                joinColumns = @JoinColumn(name = "id_prenda"),
                inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private List<Prenda> prendas;

}
