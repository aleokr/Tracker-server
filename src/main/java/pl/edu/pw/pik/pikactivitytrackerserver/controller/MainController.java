package pl.edu.pw.pik.pikactivitytrackerserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.MainDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.DTO.TokenDTO;
import pl.edu.pw.pik.pikactivitytrackerserver.model.Website;
import pl.edu.pw.pik.pikactivitytrackerserver.service.MainService;
import pl.edu.pw.pik.pikactivitytrackerserver.service.WebsiteService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/user")
@CrossOrigin(origins="*")
public class MainController {

    @Autowired
    MainService mainService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<MainDTO>> getMainData(@PathVariable int userId)
    {
        List<MainDTO> mainDTOList = mainService.getMainData(userId);

        if(mainDTOList != null)
        {
            return new ResponseEntity<>(mainDTOList, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
    }
}
