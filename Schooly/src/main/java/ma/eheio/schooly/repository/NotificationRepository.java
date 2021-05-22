package ma.eheio.schooly.repository;

import java.util.List;

import ma.eheio.schooly.model.Notification;

public interface NotificationRepository {

	public void add(Notification notification);
	public void update(Notification notification);
	public void delete(Notification notification);
	public List<Notification> getAll();
	public Notification getById(Long id);
}
