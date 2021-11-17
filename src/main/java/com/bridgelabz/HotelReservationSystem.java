package com.bridgelabz;

import java.util.HashMap;

public class HotelReservationSystem {
    HashMap<String ,Hotel> hotels = new HashMap<>();
    /**
     * This method is used to add hotels to hotel reservation system
     * with all the rates and stored in the hashmap
     */
    public int addHotel() {
        Hotel hotel1 = new Hotel("LakeWood",110,90,80, 80,3);
        Hotel hotel2 = new Hotel("BridgeWood",150,50,110, 50,4);
        Hotel hotel3 = new Hotel("RidgeWood",220,150,100, 40,5);
        hotels.put(hotel1.getHotelName(),hotel1);
        hotels.put(hotel2.getHotelName(),hotel2);
        hotels.put(hotel3.getHotelName(),hotel3);
        return hotels.size();
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println("====================================");
    }
}