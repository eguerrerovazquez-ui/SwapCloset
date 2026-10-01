package es.safareyes.swapcloset.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "usuario", schema = "swapcloset")
@Getter @Setter @EqualsAndHashCode @NoArgsConstructor @AllArgsConstructor @ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contrasena")
    private String contrasena;

    @Column(name = "autorizacion")
    private String autorizacion;

    @Column(name = "fecharegistro")
    private Timestamp fechaRegistro;

    @Column(name = "email")
    private String email;

    @Column(name = "fechanacimiento")
    private Date fechaNacimiento;




}
