package com.owdaawad.business.reservation.reservationbusinessservices.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import com.owdaawad.business.reservation.reservationbusinessservices.domain.Guest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("GUESTSERVICES")
public interface GuestService {

    @RequestMapping(value="/guests", method= RequestMethod.GET)
    List<Guest> findAll(@RequestParam(name = "emailAddress", required = false) String emailAddress);

    @RequestMapping(value = "/guests/{id}", method = RequestMethod.GET)
    Guest findOne(@PathVariable(name = "id") long id);
}
