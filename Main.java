
/** 
* CarRent.java - calculates best rate for renting the car  
* Author: Elena Mudrakova     
* Module: 5 

* Problem Statement: this progran takes user input (car color, size and 
* number of rent days) and calculates the best rate for user, if it's better to rent
* the car for the whole amount of weeks or for the weeks and the rest of the days
*  
* 
* Algorithm: 
*   ask user for an input car color
*   ask user for an input car size
*   ask user for how many days he needs the car
*   declare vars with user inputs
*   declare const (rates for each kind of car)
*   declare formulas for calculating the rate for each type of car
*   (we calculate 1st quote: amount of weeks and days user gives us)
*   (we calculate 2nd quote: amount of whole weeks user gives us + 1 more week)
*   format all quotes
*   write if else stmt dependign on what color and size user choose
*   write if else stmt inside of stmt above compariing quotes for each case
*   print the best rate for user
*   
*   
*   
*/   

import java.util.Scanner;
import java.text.NumberFormat ;
import java.text.DecimalFormat;

public class Main
{
    public static void main (String[] args)
    {
        Scanner keyboard = new Scanner(System.in) ;
        //Ask for user input
        System.out.println("\nWhat color car would you like to rent?"+
        "(enter white, black or red)");
        String carColor = keyboard.nextLine(); //declare car color
        
        System.out.println("\nWhat car would you like to rent economy or full-size?"+
        "(enter word economy or word full)");
        String carSize = keyboard.nextLine(); //declare car size
        
        System.out.println("\nEnter number of days you want to rent the car:");
        int rentDays = keyboard.nextInt(); //declare number of days
        
        //Declare vars
        //White car
        final double EC_DAYLY = 25.50;         //economy daily rate 
        final double FULL_DAYLY = 39.40;       //full-size daily rate
        final double EC_WEEKLY = 120.50;       //economy weekly rate
        final double FULL_WEEKLY = 216.25;     //full-size weekly rate
        //Red car
        final double EC_DAYLY_RED = 29.30;         //economy daily rate red color
        final double FULL_DAYLY_RED = 45.30;       //full-size daily rate red color
        final double EC_WEEKLY_RED = 138.60;       //economy weekly rate red color
        final double FULL_WEEKLY_RED = 248.70;     //full-size weekly rate red color
        
        //Number of days for rent
        int rentWeeks = rentDays / 7;   //number of whole weeks 
        int restDays = rentDays % 7;    //declare number of rest days 
        int addWeeks = rentWeeks + 1;   //user weeks+1 week
        
        //Rate calculations for black/white car
        double firstQuoteEc = rentWeeks * EC_WEEKLY + restDays * EC_DAYLY;          //rate for user choice of weeks and days economy
        double secQuoteEc = (rentWeeks + 1) * EC_WEEKLY;                            //rate for user choice of weeks + 1 week economy
        double firstQuoteFull = rentWeeks * FULL_WEEKLY + restDays * FULL_DAYLY;    //rate for user choice of weeks and days full
        double secQuoteFull = (rentWeeks + 1) * FULL_WEEKLY;                        //rate for user choice of weeks + 1 week full
        
        //Rate calculations for red car
        double firstQuoteEcRed = rentWeeks * EC_WEEKLY_RED + restDays * EC_DAYLY_RED;        //rate for user choice of weeks and days economy
        double secQuoteEcRed = (rentWeeks + 1) * EC_WEEKLY_RED;                              //rate for user choice of weeks + 1 week economy
        double firstQuoteFullRed = rentWeeks * FULL_WEEKLY_RED + restDays * FULL_DAYLY_RED;  //rate for user choice of weeks and days full
        double secQuoteFullRed = (rentWeeks + 1) * FULL_WEEKLY_RED;                          //rate for user choice of weeks + 1 week full
        
        //Formatting
        DecimalFormat formattingPayment = new DecimalFormat("000.00") ;
        String firstQuoteEcFormatted = formattingPayment.format(firstQuoteEc);
        String secQuoteEcFormatted = formattingPayment.format(secQuoteEc);
        String firstQuoteFullFormatted = formattingPayment.format(firstQuoteFull);
        String secQuoteFullFormatted = formattingPayment.format(secQuoteFull);
        
        String firstQuoteEcRedFormatted = formattingPayment.format(firstQuoteEcRed);
        String secQuoteEcRedFormatted = formattingPayment.format(secQuoteEcRed);
        String firstQuoteFullRedFormatted = formattingPayment.format(firstQuoteFullRed);
        String secQuoteFullRedFormatted = formattingPayment.format(secQuoteFullRed);
        
        
        //Check if user takes economy size white/black
        if(carColor.equals("white") || carColor.equals("black") && carSize.equals("economy"))
        {
           //Check which quote is bigger
                if(firstQuoteEc < secQuoteEc)
                { 
                    System.out.println("\nYour best rate for " + rentWeeks + " weeks and " + 
                                        restDays + " days is " + firstQuoteEcFormatted + 
                                        " dollars");
                }
                else
                {
                     System.out.println("\nWe suggest you to rent the car for " + addWeeks + " weeks for " 
                                         + secQuoteEcFormatted + " dollars instead of " +
                                         rentWeeks + " weeks and " + restDays + " days for " + 
                                         firstQuoteEcFormatted + " dollars because it's cheaper!");
                }
        }
        //Check if user takes full size white/black
        else if(carColor.equals("white") || carColor.equals("black") && carSize.equals("full"))
        {
           
                if(firstQuoteFull < secQuoteFull)
                {
                    System.out.println("\nYour best rate for " + rentWeeks + 
                                        " weeks and " + restDays + " days is " 
                                        + firstQuoteFullFormatted + " dollars");
                                        
                }
                else
                {
                     System.out.println("\nWe suggest you to rent the car for " + addWeeks + 
                                         " weeks for " + secQuoteFullFormatted + 
                                        " dollars instead of " +
                                        rentWeeks + " weeks and " + restDays + " days for " + 
                                        firstQuoteFullFormatted + " dollars because it's cheaper!");
                }
        }
        //Check if user takes economy size red
        else if(carColor.equals("red") && carSize.equals("economy"))
        {
                if(firstQuoteEcRed < secQuoteEcRed)
                {
                    System.out.println("\nYour best rate for " + rentWeeks + 
                                        " weeks and " + restDays + " days is " + 
                                        firstQuoteEcRedFormatted + " dollars");
                                        
                }
                else
                {
                     System.out.println("\nWe suggest you to rent the car for " + addWeeks + 
                                         " weeks for " + secQuoteEcRedFormatted + " dollars instead of " +
                                        rentWeeks + " weeks and " + restDays + " days for " 
                                        + firstQuoteEcRedFormatted + " dollars because it's cheaper!");
                } 
        }
        //Check if user takes full size red
        else if(carColor.equals("red") && carSize.equals("full"))
        {
                if(firstQuoteFullRed < secQuoteFullRed)
                {
                    System.out.println("\nYour best rate for " + rentWeeks + 
                                        " weeks and " + restDays + " days is " + 
                                        firstQuoteFullRedFormatted +  " dollars");
                   
                }
                else
                {
                     System.out.println("\nWe suggest you to rent the car for " + addWeeks + 
                                         " weeks for " + secQuoteFullRedFormatted + 
                                        " dollars instead of " + rentWeeks + " weeks and " 
                                        + restDays + " days for " + firstQuoteFullRedFormatted +
                                         " dollars because it's cheaper!");
                } 
        }
            
   
        
   }
}