package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationSystemTest {
    HotelReservationSystem hotel;
    @Before
    public void initializeClass(){
        hotel = new HotelReservationSystem();
    }
    @Test
    public void givenHotelNamesWhenAddedShouldReturnSize(){
        Assert.assertEquals(3,hotel.addHotel());
    }
}