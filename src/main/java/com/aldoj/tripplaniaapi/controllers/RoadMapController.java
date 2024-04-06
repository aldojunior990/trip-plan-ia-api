package com.aldoj.tripplaniaapi.controllers;

import com.aldoj.tripplaniaapi.models.GPTResponseDTO;
import com.aldoj.tripplaniaapi.models.TripRequestDTO;
import com.aldoj.tripplaniaapi.services.GPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("roadmap")
public class RoadMapController {

    @Autowired
    private GPTService gptService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/generate")
    public ResponseEntity<GPTResponseDTO> generateRoadMap(@RequestParam("currentLocal") String currentLocal, @RequestParam("destination") String destination, @RequestParam("countOfDays") String countOfDays, @RequestParam("travelDate") String travelDate) {
        var tripRequestDTO = new TripRequestDTO(currentLocal, destination, countOfDays, travelDate);
        return gptService.generateRoadMap(tripRequestDTO);
    }
}
