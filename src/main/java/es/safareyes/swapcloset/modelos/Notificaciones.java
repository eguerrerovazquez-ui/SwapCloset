package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "notificacion", schema = "swapcloset")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private Perfil id_perfil;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "texto")
    private String texto;

    @Column(name = "fecha")
    private Timestamp fecha;

    @Column(name = "fechaleida")
    private Timestamp fechaleida;
}
