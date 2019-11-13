/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author tonnyhuey
 */
import java.util.Scanner;
import java.math.*;
public class processBinary {
     int n;
    Scanner sc;
  
    public processBinary(){ // Constructor
        n = 0;
        sc = new Scanner(System.in);
    }
  
    public void printInfo(){
        System.out.println("This program accepts strings from user. It then checks");
        System.out.println("if the strings are valid unsigned binary numbers or not.");
        System.out.println("Then it returns the decimal equivalent of the binary value.\n");
    }
  
    public boolean validateNumber(String binary){
        if(binary.length() == 8){ // If length is 8
            for(int i = 0; i < binary.length(); i++){
                // If found a character other than 0 or 1
                if(binary.charAt(i) != '0' && binary.charAt(i) != '1')
                    return false; // return false
            }
            // return true if all are 0 and 1
            return true;
        }
        return false; // if length is not 8
    }
  
    public int evaluateNumber(String binary){
        int i, decimal = 0, index = binary.length() - 1;
        for(i = index; i >= 0; i--){ // move from right to left
            // Converting to decimal using binaryto decimal formula
            decimal = decimal + Character.getNumericValue(binary.charAt(i)) * (int)Math.pow(2, index - i);
        }
        return decimal;
    }
  
    public void processUserNumbers(){
        System.out.print("How many numbers you have? ");
        n = sc.nextInt();
        String binary;
        for(int i = 1; i <= n; i++){ // For n times
            System.out.print("Enter the string: ");
            binary = sc.next();
            if(validateNumber(binary)){ // if valid, process number
                System.out.println("Status: Valid.");
                System.out.println("Decimal Value: " + evaluateNumber(binary));
            }
            else
                System.out.println("Status: Invalid.");
        }
    }
  
    public static void main(String args[]){
        processBinary object;
        object = new processBinary();
        object.printInfo();
        object.processUserNumbers();
        
    }
}

