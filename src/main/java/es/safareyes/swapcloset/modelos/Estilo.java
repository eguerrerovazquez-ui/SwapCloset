package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "estilo")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Estilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoEstilo tipo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "perfil_estilo",
            joinColumns = @JoinColumn(name = "id_perfil"),
            inverseJoinColumns = @JoinColumn(name = "id_estilo"))
    private List<Estilo> tieneEstilo;
}
