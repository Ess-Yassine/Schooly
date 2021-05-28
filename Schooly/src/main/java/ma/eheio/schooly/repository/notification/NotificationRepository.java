package ma.eheio.schooly.repository.notification;

import java.util.List;

import ma.eheio.schooly.model.Notification;

public interface NotificationRepository {

	void add(Notification notification);
	void update(Notification notification);
	void delete(Notification notification);
	List<Notification> findAll();
	Notification findById(Long id);
}
