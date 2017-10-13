package com.owdaawad.business.reservation.reservationbusinessservices.client;

import com.owdaawad.business.reservation.reservationbusinessservices.domain.Guest;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;


@Component
public class GuestServiceFallbackImpl implements GuestService {

    @Override
    public List<Guest> findAll(String emailAddress) {
        return Collections.emptyList();
    }

    @Override
    public Guest findOne(long id) {
        Guest guest = new Guest();
        guest.setFirstName("Guest");
        guest.setLastName("Occupied");

        return guest;
    }
}
