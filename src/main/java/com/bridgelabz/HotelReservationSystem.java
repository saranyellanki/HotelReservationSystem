package com.bridgelabz;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelReservationSystem {
    HashMap<String ,Hotel> hotels = new HashMap<>();
    private int cheapHotelPrice;
    private String cheapHotelName;

    /**
     * This method is used to add hotels to hotel reservation system
     * Rates are added according to weekday or weekend for every hotel
     * Can add any number of hotels till he chooses Exit option
     */
    public void addHotel() {
        Scanner sc = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit){
            Hotel hotel = new Hotel();
            System.out.println("Enter \n1.Add Hotel \n2.Add Rates \n3.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1 -> {
                    System.out.println("Enter hotel name");
                    String hotelName = sc.nextLine();
                    hotel.setHotelName(hotelName);
                    hotels.put(hotelName,hotel);
                }
                case 2 -> {
                    System.out.println("Enter hotel name for which you want to add rates");
                    String name = sc.nextLine();
                    if(hotels.containsKey(name)){
                        System.out.println("Enter Weekday rate");
                        int weekdayRate = sc.nextInt();
                        hotel.setWeekdayRegularRate(weekdayRate);
                        System.out.println("Enter Weekend rate");
                        int weekendRate = sc.nextInt();
                        hotel.setWeekendRegularRate(weekendRate);
                        hotels.put(name,hotel);
                    }else System.out.println("Enter a valid hotel name");
                }
                default -> isExit = true;
            }
        }
    }

    /**
     * This method contains a regular expression which validates date
     * @return true if matches else false
     */
    public boolean isDateValid() {
        Scanner sc = new Scanner(System.in);
        String regex = "^[0-9]{2}[a-zA-Z]{3}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Enter your dates in the format dd/mm/yyy,example-10Sep2020");
        String date = sc.nextLine();
        String date1 = sc.nextLine();
        Matcher matcher = pattern.matcher(date);
        Matcher matcher1 = pattern.matcher(date1);
        return matcher.matches() && matcher1.matches();
    }

    /**
     * This method finds the cheapest hotel in the given hotels by calculating
     * regular rates and number of days
     */
    public void findCheapestHotel() {
        int hotelPrice = 0;
        int numOfDays = 2;
        if (isDateValid()) {
            for (HashMap.Entry<String, Hotel> entry : hotels.entrySet()) {
                hotelPrice = entry.getValue().weekdayRegularRate * numOfDays;
                if (hotelPrice < cheapHotelPrice) {
                    cheapHotelPrice = hotelPrice;
                    cheapHotelName = entry.getKey();
                }
            }
            System.out.println("Cheapest hotel name and prices are :");
            System.out.println(cheapHotelName + " , Total Rate : $" + cheapHotelPrice);
        }else System.out.println("Entered dates are invalid");
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println("====================================");
        HotelReservationSystem hotelObj = new HotelReservationSystem();
        hotelObj.addHotel();
        hotelObj.findCheapestHotel();
    }
}