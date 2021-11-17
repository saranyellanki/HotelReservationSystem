package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
    HotelReservationSystem hotel;
    @Before
    public void initializeClass(){
        hotel = new HotelReservationSystem();
    }
    @Test
    public void givenHotelsWhenAddedShouldReturnCheapestHotelPrice(){
        hotel.addHotel();
        Assert.assertEquals(220,hotel.findCheapestHotel("11Sep2020","12Sep2020"));
    }
}
