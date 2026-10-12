package es.safareyes.swapcloset.repositorio;

import es.safareyes.swapcloset.modelos.Notificaciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificacionesRepository extends JpaRepository<Notificaciones, Integer> {
}
