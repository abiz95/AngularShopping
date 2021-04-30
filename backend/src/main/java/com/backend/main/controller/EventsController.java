//package com.backend.main.controller;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.backend.main.model.EventsDetailModel;
//import com.backend.main.model.EventsModel;
//import com.backend.main.service.EventsService;
//import com.sun.net.httpserver.Authenticator.Success;
//
//@CrossOrigin(origins="http://localhost:4200")
//@RestController
//public class EventsController {
//
//	@Autowired
//	private EventsService eventsService;
//	
//	static final Logger logger = LoggerFactory.getLogger(EventsController.class);	
//	
//	@GetMapping("/allEvents/")
//    public ResponseEntity<?> getAllEvents() {
//       
//		List<EventsModel> eventsList = null;
//        try {
//        	eventsList = eventsService.getAllEvents();
//            logger.info("[EventsController] [getAllEvents] getting all events detail");
//           
//        } catch (Exception e) {
//            // TODO: handle exception
//            logger.error("[EventsController] [getAllEvents] error occured while retriving events detail"+e);
//            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
//        }
//        return new ResponseEntity<>(eventsList, HttpStatus.OK);
//    }
//	
//	@GetMapping("/special/")
//    public ResponseEntity<?> getSpecialEvents() {
//       
//		List<EventsModel> eventsList = null;
//        try {
//        	eventsList = eventsService.getAllEvents();
//            logger.info("[EventsController] [getSpecialEvents] getting all special events detail");
//           
//        } catch (Exception e) {
//            // TODO: handle exception
//            logger.error("[EventsController] [getSpecialEvents] error occured while retriving special events detail"+e);
//            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
//        }
//        return new ResponseEntity<>(eventsList, HttpStatus.OK);
//    }
//	
//    @PostMapping("/saveEvent/")
//    public ResponseEntity<?> saveEvent(@RequestBody EventsDetailModel eventsDetailModel) {
//       
//        try {
//        	eventsService.saveEvent(eventsDetailModel);;
//            logger.info("[EventsController] [saveEvent] saving event details...");
//           
//        } catch (Exception e) {
//            // TODO: handle exception
//            logger.error("[EventsController] [saveEvent] error occured while saving event details"+e);
//            return new ResponseEntity<Error>(HttpStatus.CONFLICT);
//        }
//        return new ResponseEntity<Success>(HttpStatus.OK);
//    }
//	
//}
