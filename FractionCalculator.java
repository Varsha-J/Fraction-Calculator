package com.comapny.java;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FractionCalculator {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");
        System.out.println(String.format("%80s","-").replace(' ', '-'));
        String operator = getOperation(input);
        Fraction fraction1;
        Fraction fraction2;
        Fraction fraction = new Fraction();
        while(!operator.toLowerCase().startsWith("q")){
            fraction1 = getFraction(input);
            fraction2 = getFraction(input);
            if (operator.equals("=")) {
                fraction1.toLowestTerms();
                fraction2.toLowestTerms();
                System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + " is " + fraction1.equals(fraction2));
            }
            else {
                switch (operator) {
                    case "+":
                        fraction = fraction1.add(fraction2);
                        break;

                    case "-":
                        fraction = fraction1.sub(fraction2);
                        break;

                    case "*":
                        fraction = fraction1.multiply(fraction2);
                        break;

                    case "/":
                        fraction = fraction1.divide(fraction2);
                        break;

                }
                fraction.toLowestTerms();
                System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + " = " + fraction);
                System.out.println(String.format("%80s","-").replace(' ', '-'));
            }
            operator = getOperation(input);
        }
    }

    public static String getOperation(Scanner input){
        char[] arr = {'+', '-', '/', '*', 'q', 'Q', '='};
        System.out.print("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operator = input.nextLine();
        while(!Arrays.toString(arr).replace(" ","").contains(operator) || operator.isEmpty()){
            System.out.print("Invalid input (+, -, /, *, = or Q to quit): ");
            operator = input.nextLine();
        }
        return operator;
    }

    public static Fraction getFraction(Scanner input){
        System.out.print("Please enter a fraction (a/b) or (a): ");
        String frac = input.nextLine();
        Fraction fraction;
        while(!validFraction(frac)){
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            frac = input.nextLine();
        }
        if(frac.contains("/")) {
            String[] arrOfStr = frac.split("/");
            fraction = new Fraction(parseInt(arrOfStr[0]), parseInt(arrOfStr[1]));
        }
        else{
            fraction = new Fraction(parseInt(frac));

        }
        return fraction;
    }

    public static boolean validFraction(String frac){
        if(frac.contains("/")){
            String[] arrOfStr = frac.split("/");
            try{
                Integer.parseInt(arrOfStr[0]);
                Integer.parseInt(arrOfStr[1]);
                Fraction temp = new Fraction(parseInt(arrOfStr[0]), parseInt(arrOfStr[1]));
            }
            catch(IllegalArgumentException e){

                return false;
            }
        }
        else{
            try{
                Integer.parseInt(frac);
            }
            catch(IllegalArgumentException e){

                return false;
            }
        }
        return true;
    }
}
