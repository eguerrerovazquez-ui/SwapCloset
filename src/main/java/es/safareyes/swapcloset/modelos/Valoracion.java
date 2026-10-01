package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "valoracion", schema = "swapcloset")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private Perfil id_perfil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitud")
    private Solicitud id_solicitud;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @Column(name = "fecha")
    private Timestamp fecha;

    @Column(name = "comentario")
    private String comentario;
}
