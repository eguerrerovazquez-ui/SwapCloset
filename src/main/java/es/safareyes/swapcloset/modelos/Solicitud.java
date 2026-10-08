package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "solicitud")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfil")
    private Perfil id_perfil;

    @Enumerated(EnumType.STRING) //Contemplamos cambiar la base de datos para los enum, sus campos seran numericos
    @Column(name = "tipo")
    private TipoSolicitud tipo;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estados estado;

    @Column(name = "fechacreacion")
    private Timestamp fechacreacion;

    @Column(name = "fechafin")
    private Timestamp fechafin;

    @Column(name = "fechainicio")
    private Timestamp fechainicio;

    @Column(name = "fechacaducidad")
    private Timestamp fechacaducidad;
}
