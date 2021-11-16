package com.bridgelabz;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelReservationSystem {
    HashMap<String ,Hotel> hotels = new HashMap<>();
    private int cheapHotelPrice = Integer.MAX_VALUE;
    private String cheapHotelName;
    private int hotelPrice;

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
     * This method finds the cheapest hotel in the given hotels
     * Weekdays and weekends both are considered and total price is calculated
     * The Cheapest hotels after total value is printed
     */
    public void findCheapestHotel() {
        String newCheapHotel = " ";
        if (isDateValid()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the days of the week");
            String day = sc.nextLine().toLowerCase(Locale.ROOT);
            String day1 = sc.nextLine().toLowerCase(Locale.ROOT);
            for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                if (day.equals("sun") && day1.equals("sat") || day1.equals("sun") && day.equals("sat")) {
                    hotelPrice = entry.getValue().weekendRegularRate * 2;
                } else if (day.equals("mon") && day1.equals("sun") || day1.equals("mon") && day.equals("sun")
                        || day.equals("sat") && day1.equals("fri") || day1.equals("sat") && day.equals("fri")) {
                    hotelPrice = entry.getValue().weekdayRegularRate + entry.getValue().weekendRegularRate;
                } else {
                    hotelPrice = entry.getValue().weekdayRegularRate * 2;
                }
                if (hotelPrice < cheapHotelPrice) {
                    cheapHotelPrice = hotelPrice;
                    cheapHotelName = entry.getKey();
                }
                if(cheapHotelPrice==hotelPrice){
                    if(!cheapHotelName.equals(entry.getKey())) newCheapHotel = entry.getKey();
                }
            }
            System.out.println("Hotel name : "+cheapHotelName+", "+newCheapHotel + " Total Rate : $"+cheapHotelPrice);
        } else System.out.println("Entered dates are invalid");
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