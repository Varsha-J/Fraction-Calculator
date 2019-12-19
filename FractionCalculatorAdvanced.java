package com.comapny.java;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FractionCalculatorAdvanced {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Valid operations are of the form \"[FRAC] [OPERATION] [FRAC]\".");
        System.out.println("[FRAC] can be either a single integer or two integers seperated by \"/\".");
        System.out.println("[OPERATION] can be +, -, *, / or =");
        System.out.println(String.format("%80s","-").replace(' ', '-'));
        System.out.print("Enter an operation (q to quit): ");
        String operation = input.nextLine();
        String[] arrOfStr;
        while(!operation.equals("q")){
            arrOfStr = operation.split(" ");
            boolean valid = check(arrOfStr);
            while(!valid){
                System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\". ");
                System.out.print("Enter an operation (q to quit): ");
                operation = input.nextLine();
                arrOfStr = operation.split(" ");
                valid = check(arrOfStr);
            }
        String operator = arrOfStr[1];
        Fraction fraction1 = getFraction(arrOfStr[0]);
        Fraction fraction2 = getFraction(arrOfStr[2]);
        Fraction fraction = new Fraction();
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

                case "=":
                    boolean val = fraction1.equals(fraction2);
                    break;

            }
            fraction.toLowestTerms();
            System.out.println(fraction1.toString() + " " + operator + " " + fraction2.toString() + " = " + fraction);

        }
            System.out.print("Enter an operation (q to quit): ");
            operation = input.nextLine();
    }
    }


    public static String getOperation(Scanner input){
        char[] arr = {'+', '-', '/', '*', 'q', 'Q', '='};
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit): ");
        String operator = input.nextLine();
        while(!Arrays.toString(arr).replace(" ","").contains(operator) || operator.isEmpty()){
            System.out.println("Invalid input (+, -, /, *, = or Q to quit): ");
            operator = input.nextLine();
        }
        return operator;
    }

    public static Fraction getFraction(String frac){

        Fraction fraction = new Fraction();
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

    public static boolean check(String[] arr){
        char[] ar = {'+', '-', '/', '*', 'q', 'Q', '='};
        if(arr.length !=3){
            return false;
        }
        else if(!Arrays.toString(arr).replace(" ","").contains(arr[1]) || arr[1].isEmpty()){
            return false;
        }else if(!validFraction(arr[0]) || !validFraction(arr[2])){
            return false;
        }
        return true;
    }
}
