package com.owdaawad.business.reservation.reservationbusinessservices;

import com.owdaawad.business.reservation.reservationbusinessservices.domain.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RoomReservationController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/rooms",method = RequestMethod.GET)
    public List<Room> getAllRooms(){

        /**
         * Note in following:
         * 1. ROOMSERVICES: this Ribbon will get it from Eureka
         * 2. Ribbon will make the call thru Eureka, making code replacement and get the URL for our room services URL.
         * JUST WOW!!
         */
        ResponseEntity<List<Room>> roomsResponse = this.restTemplate.exchange(
                "http://ROOMSERVICES/rooms", HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
                }
        );

        return roomsResponse.getBody();
    }
}
