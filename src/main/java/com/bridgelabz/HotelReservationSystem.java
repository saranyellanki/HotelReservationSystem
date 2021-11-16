package com.bridgelabz;

import java.util.HashMap;
import java.util.Scanner;

public class HotelReservationSystem {
    HashMap<String ,Hotel> hotels = new HashMap<>();

    /**
     * This method is used to add hotels to hotel reservation system
     * Can add any number of hotels till he chooses Exit option
     */
    public void addHotel() {
        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit){
            System.out.println("Enter \n1.Add Hotel \n2.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1 -> {
                    Hotel hotel = new Hotel();
                    System.out.println("Enter hotel name");
                    String hotelName = sc.nextLine();
                    hotel.setHotelName(hotelName);
                    hotels.put(hotelName, hotel);
                }
                default -> {
                    isExit = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println("====================================");
        HotelReservationSystem hotelObj = new HotelReservationSystem();
        hotelObj.addHotel();
    }
}