package ma.eheio.schooly.services.notification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.eheio.schooly.model.Notification;
import ma.eheio.schooly.repository.notification.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	NotificationRepository notificationRepository;
	
	@Override
	public void add(Notification notification) {
		notificationRepository.add(notification);
	}

	@Override
	public void update(Notification notification) {
		notificationRepository.update(notification);
	}

	@Override
	public void delete(Notification notification) {
		notificationRepository.delete(notification);
	}

	@Override
	public Notification findById(Long id) {
		return notificationRepository.findById(id);
	}

	@Override
	public List<Notification> findAll() {
		return notificationRepository.findAll();
	}

}
