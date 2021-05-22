package ma.eheio.schooly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import ma.eheio.schooly.model.Notification;

@Component
public interface NotificationRepositoryJpa extends JpaRepository<Notification, Long> {

	
}
