/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Liam Pido
 */

/*
Exercise 17 - Blood Alcohol Calculator

Sometimes you have to perform a more complex calculation based on some provided inputs and then use that result to make a determination.

Create a program that prompts for your weight, gender, number of drinks, the amount of alcohol by volume of the drinks consumed (as a percent),
and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

BAC = (A × 5.14 / W × r) − .015 × H

where

A = (number of drinks * alcohol by volume) is total alcohol consumed, in ounces (oz).
W is body weight in pounds.
r is the alcohol distribution ratio:
0.73 for men
0.66 for women
H is number of hours since the last drink.

Display whether or not it’s legal to drive by comparing the blood alcohol content to 0.08.

Example Output

Your BAC is 0.08
It is not legal for you to drive.

Constraint

Prevent the user from entering non-numeric values.

Challenges

Handle metric units.
Look up the legal BAC limit by state and prompt for the state. Display a message that states whether or not it’s legal to drive based on the computed BAC.
Develop this as a mobile application that makes it easy to record each drink, updating the BAC each time a drink is entered.
 */

package base;

import java.util.Scanner;

//Create a program that prompts for your weight, gender, number of drinks, the amount of alcohol by volume of the drinks consumed (as a percent),
//and the amount of time since your last drink. Calculate your blood alcohol content (BAC) using this formula

public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        App myApp = new App();

        double W = myApp.readWeight();
        String gender = myApp.readGender();
        double r = myApp.findR(gender);
        double A = myApp.readAlcohol();
        int H = myApp.readHours();
        myApp.output(W, r, A, H);
    }



    public void output(double W, double r, double A, int H) {
        // BAC = (A × 5.14 / W × r) − .015 × H
        double B = A * 5.14;
        double BB = W * r;
        double C = .015 * H;
        double BAC = (B / BB) - C;
        System.out.print(BAC);
    }

    public int readHours() {
        System.out.print("How long has it been since your last drink? (in hours) ");
        int hours = in.nextInt();
        return hours;
    }

    public double readAlcohol() {
        System.out.print("How many drinks have you had? ");
        int drinks = in.nextInt();
        System.out.print("Alcohol by volume percentage? ");
        double percentage = in.nextDouble();

        double A = drinks * percentage;
        return A;
    }

    public double findR(String gender) {
        if(gender.equals("M")) {
            return 0.73;
        } else if(gender.equals("W")) {
            return 0.66;
        }

        return 0;
    }

    public String readGender() {
        System.out.print("Gender (M/W) ");
        String gender = in.nextLine();
        return gender;
    }

    public double readWeight() {
        System.out.print("What is your weight? (in pounds): ");
        String input = in.nextLine();
        double weight = Double.parseDouble(input);
        return weight;
    }
}
