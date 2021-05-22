package ma.eheio.schooly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ma.eheio.schooly.model.Notification;

@Repository
public class NotificationRepositoryHibernate implements NotificationRepository {

	@Autowired
	NotificationRepositoryJpa notificationRepositoryJpa;
	
	@Override
	public void add(Notification notification) {
		notificationRepositoryJpa.save(notification);
	}

	@Override
	public void update(Notification notification) {
		notificationRepositoryJpa.save(notification);
	}

	@Override
	public void delete(Notification notification) {
		notificationRepositoryJpa.delete(notification);
	}

	@Override
	public List<Notification> getAll() {
		return notificationRepositoryJpa.findAll();
	}

	@Override
	public Notification getById(Long id) {

		Notification notification = null;

		Optional<Notification> NotificationOptional = notificationRepositoryJpa.findById(id);
		
		notification = NotificationOptional.get();
		
		if (!NotificationOptional.isPresent()) {
			
			throw new RuntimeException("Notification not Font" + id);
		}
		return notification;
	}

}
