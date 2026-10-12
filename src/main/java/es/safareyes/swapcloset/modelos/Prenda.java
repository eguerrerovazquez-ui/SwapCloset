package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "prenda")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "talla")
    private Talla talla;

    @Enumerated(EnumType.STRING)
    @Column(name = "modalidad")
    private ModalidadIntercambio modalidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadosMensajes estado;

    @Column(name = "fechaalta")
    private Timestamp fechaalta;

    @Column(name = "fechabaja")
    private Timestamp fechabaja;

}
