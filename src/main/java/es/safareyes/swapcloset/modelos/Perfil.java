package es.safareyes.swapcloset.modelos;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "perfil", schema = "swapcloset")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Perfil {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    @Column(name = "tallacamiseta")
    private String tallacamiseta;

    @Column(name = "tallapantalones")
    private String tallapantalones;

    @Column(name = "tallacalzado")
    private String tallacalzado;

    @Column(name = "reputacion")
    private BigDecimal reputacion;

}
