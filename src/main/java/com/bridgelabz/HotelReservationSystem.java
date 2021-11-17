package com.bridgelabz;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelReservationSystem {
    HashMap<String ,Hotel> hotels = new HashMap<>();
    private String cheapHotelName;

    /**
     * This method is used to add hotels to hotel reservation system
     * with all the rates and stored in the hashmap
     * @return size of the hashmap
     */
    public int addHotel() {
        Hotel hotel1 = new Hotel("LakeWood", 110, 90, 80, 80, 3);
        Hotel hotel2 = new Hotel("BridgeWood", 150, 50, 110, 50, 4);
        Hotel hotel3 = new Hotel("RidgeWood", 220, 150, 100, 40, 5);
        hotels.put(hotel1.getHotelName(), hotel1);
        hotels.put(hotel2.getHotelName(), hotel2);
        hotels.put(hotel3.getHotelName(), hotel3);
        return hotels.size();
    }

    /**
     * This method uses regular expression to validate date
     * @param date is a string type of first date
     * @param date1 is a string type of second date
     * @return boolean true if matches else false
     */
    public boolean isDateValid(String date, String date1) {
        String regex = "^[0-9]{2}[a-zA-Z]{3}[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        Matcher matcher1 = pattern.matcher(date1);
        return matcher.matches() && matcher1.matches();
    }

    /**
     * This method finds the cheapest hotel rate
     * @param date is string type which takes first date from user
     * @param date1 is string type which takes second date from user
     * @return cheapest hotel price among the list of hotels
     */
    public int findCheapestHotel(String date, String date1) {
        int cheapHotelPrice = Integer.MAX_VALUE;
        int hotelPrice;
        int numOfDays = 2;
        if (isDateValid(date, date1)) {
            for (HashMap.Entry<String, Hotel> entry : hotels.entrySet()) {
                hotelPrice = entry.getValue().getWeekdayRegularRate() * numOfDays;
                if (hotelPrice < cheapHotelPrice) {
                    cheapHotelPrice = hotelPrice;
                    cheapHotelName = entry.getKey();
                }
            }
            System.out.println("Hotel name : "+cheapHotelName + " , Total Rate : $" + cheapHotelPrice);
        } else System.out.println("Entered dates are invalid");
        return cheapHotelPrice;
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("Welcome to Hotel Reservation System");
        System.out.println("====================================");
    }
}