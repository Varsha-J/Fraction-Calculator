package com.comapny.java;


public class Fraction {
    int numerator;
    int denominator;

    public Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator){

        if(denominator == 0){
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        else if((numerator<0 && denominator<0) || (numerator>0 && denominator<0)){
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
        else{
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if(denominator==1){
            return String.valueOf(numerator);
        }
        return  numerator + "/" + denominator;
    }

    public double toDouble(){
        return (numerator/denominator);
    }

    public Fraction add(Fraction other){
        int num = (this.numerator*other.denominator)+(this.denominator*other.numerator);
        int den = this.denominator*other.denominator;
        Fraction sum = new Fraction(num,den);
        return sum;
    }

    public Fraction sub(Fraction other){
        int num = (this.numerator*other.denominator)-(this.denominator*other.numerator);
        int den = this.denominator*other.denominator;
        Fraction diff = new Fraction(num,den);
        return diff;
    }

    public Fraction multiply(Fraction other){
        int num = this.numerator*other.numerator;
        int den = this.denominator*other.denominator;
        Fraction product = new Fraction(num,den);
        return product;
    }

    public Fraction divide(Fraction other){
        int num = this.numerator*other.denominator;
        int den = this.denominator*other.numerator;
        Fraction quotient = new Fraction(num,den);
        return quotient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator &&
                denominator == fraction.denominator;
    }

    public void toLowestTerms(){

        int gcd = gcd(this.numerator, this.denominator);
        this.numerator = numerator/gcd;
        this.denominator = denominator/gcd;
    }

    public static int gcd(int num, int den){
        int rem;
        while(num!=0 && den!=0){
            rem = num%den;
            num = den;
            den = rem;
        }
        return num;

    }

    public void print(){
        System.out.println(numerator +" / "+ denominator);
    }
}
