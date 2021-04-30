//package com.backend.main.DAOImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.backend.main.DAO.EventsDAO;
//import com.backend.main.Repository.EventsRepository;
//import com.backend.main.entity.EventsEntity;
//
//@Component
//public class EventsDAOImpl implements EventsDAO {
//
//	@Autowired
//	private EventsRepository eventsRepository;
//	
//	public List<EventsEntity> getAllEvents() throws Exception {
//		return eventsRepository.findAll();
//	}
//	public void saveEvent(EventsEntity userEnt) throws Exception {
//		eventsRepository.save(userEnt);
//	}
//}
