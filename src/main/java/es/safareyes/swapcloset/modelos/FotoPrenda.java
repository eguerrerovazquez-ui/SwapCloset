package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fotoprenda")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FotoPrenda {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "url")
    private String url;

    @Column(name = "orden")
    private Integer orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prenda")
    private Prenda id_prenda;

}
