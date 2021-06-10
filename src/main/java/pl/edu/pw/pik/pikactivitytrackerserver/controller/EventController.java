package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.EventDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.StatisticsDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Event;
import pl.edu.pw.pik.pikactivitytrackerserver.service.EventService;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins="*")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping(value = "/new_event")
    public ResponseEntity<?> newEvent(@RequestBody EventDTO dto)
    {
        if(eventService.saveEvent(dto))
            return new ResponseEntity<>(null, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/getStatisticsPerDay/{webToken}/{eventName}{dateFrom}/{dateTo}")
    public ResponseEntity<?> getStatisticsDataPerDay(@PathVariable String webToken, @PathVariable String eventName,
                                               @PathVariable Timestamp dateFrom, @PathVariable Timestamp dateTo)
    {
        StatisticsDTO stats = eventService.getStatisticsPerDay(webToken, eventName, dateFrom, dateTo);
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @GetMapping(value = "/getStatisticsPerHour/{webToken}/{eventName}/{dateFrom}/{dateTo}")
    public ResponseEntity<?> getStatisticsDataPerHour(@PathVariable String webToken, @PathVariable String eventName,
                                                     @PathVariable Timestamp dateFrom, @PathVariable Timestamp dateTo)
    {
        StatisticsDTO stats = eventService.getStatisticsPerHour(webToken, eventName, dateFrom, dateTo);
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @GetMapping(value = "/getEventsNames/{websiteToken}")
    public ResponseEntity<?> getEventNames(@PathVariable String websiteToken)
    {
        List<String> list = eventService.getEventsNames(websiteToken);

        if(list == null)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else
        {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }


}
