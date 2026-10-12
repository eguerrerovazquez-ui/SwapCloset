package es.safareyes.swapcloset.TestEntrega;

import es.safareyes.swapcloset.modelos.*;
import es.safareyes.swapcloset.repositorio.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
                + ", descripcion: " + e.getDescripcion()
                + ", talla: " + e.getTalla()
                + ", modalidad: " + e.getModalidad()
                + ", estado: " + e.getEstado()
                + ", fecha de alta: " + e.getFechaalta()
        ));
    }

    @Test
    void busquedaFiltrada(){
        List<Prenda> prendas = prendaRepo.findByEstado(EstadosMensajes.BORRADOR);

        System.out.println(">>> Prendas encontrados: " + prendas.size());
        prendas.forEach(e -> System.out.println(
                "nombre: " + e.getNombre()
                + ", estado: " + e.getEstado()
        ));

    }

    @Test
    void infoPrenda(){
        for (Object[] prenda : prendaRepo.detalleDePrenda(1)) {
            Integer id = (Integer) prenda[0];
            String url = (String) prenda[1];
            String nombre = (String) prenda[2];
            Integer valoracion = (Integer) prenda[3];
            System.out.println("id: " + id + ", url: " + url + ", nombre: " + nombre + ", valoracion: " + valoracion);
        }
    }

    @Test
    void conteoPrendas(){
        for (Object[] categorias : categoriaRepo.conteoDePrendas()) {
            String nombre = (String) categorias[0];
            Long cantidad = (Long) categorias[1];
            System.out.println("Tipo: " + nombre + ", cantidad: " + cantidad);
        }
    }

    @Test
    void infoUsuario(){
        for (Object[] usuario : userRepo.infoUsuario(1)) {
            Integer id = (Integer) usuario[0];
            String nombre = (String) usuario[1];
            String tallaC = (String) usuario[2];
            String tallaP =  (String) usuario[3];
            String tallaCal =  (String) usuario[4];
            BigDecimal reputacion  = (BigDecimal) usuario[5];
            String estilos = (String) usuario[6];
            String prendas = (String) usuario[7];
            System.out.println("id: " + id
                    + ", \nnombre: " + nombre
                    + ", \ntalla de camiseta: " + tallaC
                    + ", \ntalla de pantalones: " + tallaP
                    + ", \ntalla de calzados: " + tallaCal
                    + ", \nreputacion: " + reputacion
                    + ", \nestilos: " + estilos
                    + ", \nprendas: " + prendas
            );
        }
    }

    @Test
    void estilosEnComun(){
        for (Object[] perfinles : perfilRepo.perfilesConEstilosEnComun()){
            String nombre = (String) perfinles[0];
            BigDecimal reputacion = (BigDecimal) perfinles[1];
            Long encomun = (Long) perfinles[2];
            System.out.println("nombre: " + nombre
                    + ", reputacion: " + reputacion
                    + ", estilos en comun: " + encomun
            );
        }
    }

    @Test
    void solicitudesEnCurso(){
        for (Object[] solicitudes : solicitudRepo.solicitudesEnCurso(2)) {
            String tipo = (String) solicitudes[0];
            String estado = (String) solicitudes[1];
            LocalDateTime fecha = (LocalDateTime) solicitudes[2];
            System.out.println("tipo: " + tipo + ", estado: " + estado + ", fecha: " + fecha);
        }
    }

    @Test
    void chats(){
        for (Object[] mensajes : mensajeRepo.mensajes(1,2)){
            for (int i=0; mensajes.length>i;i++){
                String mensaje = (String) mensajes[i];
                System.out.println(mensaje);
            }
        }
    }

    @Test
    void estadisticasPorCategoriaYMes() {
        Map<String, int[]> acumulado = new LinkedHashMap<>();

        for (Object[] f : prendaRepo.publicacionesPorCategoriaYMes())
            acumulado.computeIfAbsent(f[0] + "|" + f[1], k -> new int[3])[0] += ((Number) f[2]).intValue();

        for (Object[] f : solicitudRepo.intercambiosPorCategoriaYMes())
            acumulado.computeIfAbsent(f[0] + "|" + f[1], k -> new int[3])[1] += ((Number) f[2]).intValue();

        for (Object[] f : solicitudRepo.prestamosPorCategoriaYMes())
            acumulado.computeIfAbsent(f[0] + "|" + f[1], k -> new int[3])[2] += ((Number) f[2]).intValue();

        for (Map.Entry<String, int[]> e : acumulado.entrySet()) {
            String[] p = e.getKey().split("\\|");
            int[] v = e.getValue();
            System.out.printf(
                    "categoria: %-12s mes: %-7s publicaciones: %d, intercambios: %d, prestamos: %d%n",
                    p[0], p[1], v[0], v[1], v[2]
            );
        }
    }
}
