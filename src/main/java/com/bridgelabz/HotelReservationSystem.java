package com.bridgelabz;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HotelReservationSystem {
    HashMap<String ,Hotel> hotels = new HashMap<>();
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
            System.out.println("Enter \n1.Add Hotel \n3.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter hotel name");
                String hotelName = sc.nextLine();
                hotel.setHotelName(hotelName);
                System.out.println("Enter Weekday rate");
                int weekdayRate = sc.nextInt();
                hotel.setWeekdayRegularRate(weekdayRate);
                System.out.println("Enter Weekend rate");
                int weekendRate = sc.nextInt();
                hotel.setWeekendRegularRate(weekendRate);
                System.out.println("Enter hotel rating");
                int rating = sc.nextInt();
                hotel.setRating(rating);
                hotels.put(hotelName, hotel);
            } else isExit=true;
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
        System.out.println("Enter your dates in the format dd/mm/yyyy,example-10Sep2020");
        String date = sc.nextLine();
        String date1 = sc.nextLine();
        Matcher matcher = pattern.matcher(date);
        Matcher matcher1 = pattern.matcher(date1);
        return matcher.matches() && matcher1.matches();
    }

    /**
     * This method is used to calculate prices of the hotel
     * @param entry used for iterating map entry
     * @return total hotel price
     */
    public int calculateHotelPrice(Map.Entry<String,Hotel> entry){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the days of the week");
        String day = sc.nextLine().toLowerCase(Locale.ROOT);
        String day1 = sc.nextLine().toLowerCase(Locale.ROOT);
        if (day.equals("sun") && day1.equals("sat") || day1.equals("sun") && day.equals("sat")) {
             return entry.getValue().getWeekendRegularRate() * 2;
        } else if (day.equals("mon") && day1.equals("sun") || day1.equals("mon") && day.equals("sun")
                || day.equals("sat") && day1.equals("fri") || day1.equals("sat") && day.equals("fri")) {
           return entry.getValue().getWeekdayRegularRate() + entry.getValue().getWeekendRegularRate();
        } else {
            return entry.getValue().getWeekdayRegularRate() * 2;
        }
    }

    /**
     * The Cheapest hotels after total value is printed
     * If there are 2 cheap hotels then best rated hotel will be choosed
     * by sorting function which compares the objects
     */
    public void findCheapestHotel() {
        ArrayList<Hotel> cheapHotelsList = new ArrayList<>();
        int cheapHotelPrice = Integer.MAX_VALUE;
        int hotelPrice;
        if (isDateValid()) {
            for (Map.Entry<String, Hotel> entry : hotels.entrySet()) {
                hotelPrice = calculateHotelPrice(entry);
                if (hotelPrice < cheapHotelPrice) {
                    cheapHotelPrice = hotelPrice;
                    cheapHotelsList = new ArrayList<>();
                    cheapHotelsList.add(entry.getValue());
                }
                else if(cheapHotelPrice==hotelPrice){
                    cheapHotelsList.add(entry.getValue());
                }
            }
            Collections.sort(cheapHotelsList);
            int rating = cheapHotelsList.get(0).getRating();
            for(Hotel hotel : cheapHotelsList){
                if(rating==hotel.getRating()) {
                    System.out.println("Hotel name :"+hotel.getHotelName()+" Rating : "+hotel.rating+
                            " Total Rate : $"+cheapHotelPrice);
                }
            }
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