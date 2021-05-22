package ma.eheio.schooly.services;

import java.util.List;

import ma.eheio.schooly.model.Notification;


public interface NotificationService {

	void add(Notification notification);
	void update(Notification notification);
	void delete(Notification notification);
	public Notification getById(Long id);
	public List<Notification> getAll();
	
}
