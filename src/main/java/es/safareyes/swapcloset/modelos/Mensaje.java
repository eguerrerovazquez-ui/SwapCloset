package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "mensaje")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mensaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfile")
    private Perfil perfile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_perfilr")
    private Perfil perfilr;

    @Column(name = "fechaenvio")
    private Timestamp feachaenvio;

    @Column(name = "contenido")
    private String contenido;
}
