//package com.backend.main.serviceImpl;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.backend.main.DAO.EventsDAO;
//import com.backend.main.entity.EventsEntity;
//import com.backend.main.model.EventsDetailModel;
//import com.backend.main.model.EventsModel;
//import com.backend.main.service.EventsService;
//
//@Service
//public class EventsServiceImpl implements EventsService {
//
//	@Autowired
//	private EventsDAO eventsDAO;
//	
//	public List<EventsModel> getAllEvents() throws Exception {
//		
//		ArrayList<EventsModel> eventsList = new ArrayList<EventsModel>();
//		List<EventsEntity> eventsData = eventsDAO.getAllEvents();
//		for (EventsEntity eventsEntity : eventsData) {
//			EventsModel eventsModel = new EventsModel();
//			eventsModel.setEventId(eventsEntity.getEventId());
//			eventsModel.setEventName(eventsEntity.getEventName());
//			eventsModel.setEventDescription(eventsEntity.getEventDescription());
//			eventsModel.setEventDate(eventsEntity.getEventDate());
//			eventsList.add(eventsModel);
//		}
//		
//		return eventsList;
//	}
//	
//	public void saveEvent(EventsDetailModel eventsDetailModel) throws Exception {
//		
//        java.util.Date CurrentDate = new Date();
//        Date timeStamp = new java.sql.Timestamp(CurrentDate.getTime());
//        
//        EventsEntity newEvents = new EventsEntity();
//        newEvents.setEventName(eventsDetailModel.getEventName());
//        newEvents.setEventDescription(eventsDetailModel.getEventDescription());
//        newEvents.setEventDate(eventsDetailModel.getEventDate());
//        newEvents.setCre_rec_ts(timeStamp);
//        newEvents.setUpd_rec_ts(timeStamp);
//		
//        eventsDAO.saveEvent(newEvents);
//	}
//	
//}
