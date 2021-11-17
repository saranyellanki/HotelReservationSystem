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
    public void givenHotelsWhenAddedShouldReturnBestRatedHotelPrice(){
        hotel.addHotel();
        Assert.assertEquals(200,hotel.findCheapestHotel("2020-09-11","2020-09-12"));
    }
}