package es.safareyes.swapcloset.TestEntrega;

import es.safareyes.swapcloset.modelos.*;
import es.safareyes.swapcloset.repositorio.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestPrueba {

    @Autowired private IUsuarioRepository userRepo;
    @Autowired private IMensajeRepository mensajeRepo;
    @Autowired private INotificacionesRepository notiRepo;
    @Autowired private IPerfilRepository perfilRepo;
    @Autowired private ICategoriaRepository categoriaRepo;
    @Autowired private IEstiloRepository estiloRepo;
    @Autowired private IFotoPrendaRepository fotoPrendaRepo;
    @Autowired private IPrendaRepository prendaRepo;
    @Autowired private ISolicitudRepository solicitudRepo;
    @Autowired private IValoracionRepository valoracionRepo;

    @Test
    void accesoUsuarios(){
        List<Usuario> usuarios = userRepo.findAll();

        System.out.println(">>> Usuarios encontrados: " + usuarios.size());
        usuarios.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", nombre: " + e.getNombre()
                + ", contraseña: " + e.getContrasena()
                + ", email: " + e.getEmail()
                + ", autorizacion: " + e.getAutorizacion()
                + ", fecha de registro: " + e.getFechaRegistro()
                + ", fecha de naciemiento: " + e.getFechaNacimiento()
        ));
    }

    @Test
    void accesoPerfiles(){
        List<Perfil> perfiles = perfilRepo.findAll();

        System.out.println(">>> Perfiles encontrados: " + perfiles.size());
        perfiles.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", id_usuario: " + e.getId_usuario()
                + ", talla camiseta: " + e.getTallacamiseta()
                + ", talla pantalones: " + e.getTallapantalones()
                + ", talla calzado: " + e.getTallacalzado()
                + ", reputacion: " + e.getReputacion()
        ));
    }

    @Test
    void accesoCategorias(){
        List<Categoria> categorias = categoriaRepo.findAll();

        System.out.println(">>> Categorias encontrados: " + categorias.size());
        categorias.forEach(e -> System.out.println(
                "id: " + e.getIdCategoria()
                + ", nombre: " + e.getNombre()
        ));
    }

    @Test
    void accesoEstilos(){
        List<Estilo> estilos = estiloRepo.findAll();

        System.out.println(">>> Estilos encontrados: " + estilos.size());
        estilos.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", tipo: " + e.getTipo()
        ));
    }

    @Test
    void accesoFotoPrenda(){
        List<FotoPrenda> fotoPrendas = fotoPrendaRepo.findAll();

        System.out.println(">>> FotoPrendas encontrados: " + fotoPrendas.size());
        fotoPrendas.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", id_prenda: " + e.getId_prenda()
                + ", url: " + e.getUrl()
                + ", orden: " + e.getOrden()
        ));
    }

    @Test
    void accesoSolicitud(){
        List<Solicitud> solicitud = solicitudRepo.findAll();

        System.out.println(">>> Solicitud encontrados: " + solicitud.size());
        solicitud.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", id_perfil: " + e.getId_perfil()
                + ", tipo: " + e.getTipo()
                + ", estado: " + e.getEstado()
                + ", fecha de creacion: " + e.getFechacreacion()
                + ", fecha de fin:  " + e.getFechafin()
                + ", fecha de inicio: " + e.getFechainicio()
                + ", fecha de caducidad: " + e.getFechacaducidad()
        ));
    }

    @Test
    void accesoValoracion(){
        List<Valoracion> valoracion = valoracionRepo.findAll();

        System.out.println(">>> Valoracion encontrados: " + valoracion.size());
        valoracion.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", id_solicitud: " + e.getId_solicitud()
                + ", id_perfil: " + e.getId_perfil()
                + ", puntuacion: " + e.getPuntuacion()
                + ", fecha: " + e.getFecha()
                + ", comentario: " + e.getComentario()
        ));
    }

    @Test
    void accesoMensaje(){
        List<Mensaje> mensajes = mensajeRepo.findAll();

        System.out.println(">>> Mensajes encontrados: " + mensajes.size());
        mensajes.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", id_perfile: " + e.getPerfile()
                + ", id_perfilr. "  + e.getPerfilr()
                + ", fecha de envio: " + e.getFeachaenvio()
                + ", contenido: " + e.getContenido()
        ));
    }

    @Test
    void accesoNotificacion(){
        List<Notificaciones> notificaciones = notiRepo.findAll();

        System.out.println(">>> Notificaciones encontrados: " + notificaciones.size());
        notificaciones.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", id_perfil:  " + e.getId_perfil()
                + ", tipo: " + e.getTipo()
                + ", fecha: " + e.getFecha()
                + ", texto: " + e.getTexto()
                + ", fecha de lectura: " + e.getFechaleida()
        ));
    }

    @Test
    void accesoPrenda(){
        List<Prenda> prendas = prendaRepo.findAll();

        System.out.println(">>> Prendas encontrados: " + prendas.size());
        prendas.forEach(e -> System.out.println(
                "id: " + e.getId()
                + ", id_perfil" + e.getPerfil()
                + ", nombre: " + e.getNombre()
                + ", nombre: " + e.getNombre()
                + ", descripcion: " + e.getDescripcion()
                + ", talla: " + e.getTalla()
                + ", modalidad: " + e.getModalidad()
                + ", estado: " + e.getEstado()
                + ", fecha de alta: " + e.getFechaalta()
                + ", fecha de baja: " + e.getFechabaja()
        ));
    }
}
