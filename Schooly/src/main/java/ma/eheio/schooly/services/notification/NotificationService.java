package ma.eheio.schooly.services.notification;

import java.util.List;

import ma.eheio.schooly.model.Notification;


public interface NotificationService {

	void add(Notification notification);
	void update(Notification notification);
	void delete(Notification notification);
	Notification findById(Long id);
	List<Notification> findAll();
	
}
