// Author: Swopnil N. Shrestha
// Overall Worst Case: O(n) + O(log(n))
// Instructor: Dr. Alan Zaring
// Objective: Write the 'intToBitsImage' algorithm to convert decimal values into 32-bit binary representations
// Date Completed: 18/02/2019
package assignment01;
public class Assignment01 {
    
    public static void main(String[] commandLineArguments) {
        System.out.println("The image of " + Integer.MAX_VALUE + " is [" + intToBitsImage(Integer.MAX_VALUE) + "]");
        System.out.println();
        for (int subject = 8; subject >= -8; --subject)
            System.out.println("The image of " + subject + " is [" + intToBitsImage(subject) + "]");
        System.out.println();
        System.out.println("The image of " + Integer.MIN_VALUE + " is [" + intToBitsImage(Integer.MIN_VALUE) + "]");
    }
    
    // method worst case: 2O(n) + O(log(n))
    static String intToBitsImage(int subject) {
        // Check if a number is negative or positive and store the value to use later   
        boolean subjectIsNegative = subject < 0;
        if (subject == Integer.MIN_VALUE) return("10000000000000000000000000000000"); // HARD CODED IF NUMBER IS 'Integer.MIN', algorithm does not support alternative
        if (subjectIsNegative) subject *= -1; // process positive value first (implement negative using 'subjectIsNegative' afterwords)

        // Convert the decimal to a positive binary number
        String binString = decimalToBinaryString(subject);
        
        // Change positive to negative binary if initial value is negative
        if (subjectIsNegative) binString = positiveToNegativeBinary(binString);
        int charsToAdd = 32 - binString.length();
        
        String repeatString = (subjectIsNegative) ? "1" : "0"; // if negative repeater is 1, otherwise 0  
        
        // Concantate a 1 or 0 to the string based on negative or positive to make 32 characters
        // Maximum possible 32 loops O(1) ? 
        for (int i = 0; i < charsToAdd; ++i) {
            binString = repeatString + binString;
        }
        return binString;
    }
    
    // method worst case: O(log(n))
    static String decimalToBinaryString(int decimal) {
        String myBinaryString = "";
        
// Factorization of 'decimal' by 2
        while (decimal != 0 && decimal != 1) {
            if (decimal % 2 == 0) {
                myBinaryString = '0' + myBinaryString;
                decimal /= 2;
            } else {
                myBinaryString = '1' + myBinaryString;
                decimal = (decimal - 1) / 2;
            }
        }
        
        // The following lines handle edge cases when decimal might equal 0 or 1
        if (decimal == 1) {
            myBinaryString = '1' + myBinaryString;
        } else if (decimal == 0) {
            myBinaryString = '0' + myBinaryString;
        }
        return myBinaryString;
    }

    // method worst case: O(n)
    static String positiveToNegativeBinary(String posBinString) {
        String negBinString = "";
        boolean carryOver = true; // Carryover initialized as true because 1 is added to the value (functions as initial addition)
        int lastIdx = posBinString.length();

        // my implementation of the two's compliment conversion algorithm
        boolean truncate = lastIdx > 32; // possible edge cases
        for (int i = lastIdx; i > 0; i--) { // Loop from the last number to the 0th number
            String currentPos = posBinString.substring(i - 1, i);
            if ("0".equals(currentPos)) {
                // current position replaces into 1
                if (carryOver) {
                    negBinString = "0" + negBinString;
                } else {
                    negBinString = "1" + negBinString;
                }
            } else if ("1".equals(currentPos)) {
                if (carryOver) {
                    negBinString = "1" + negBinString;
                    carryOver = false;
                } else {
                    negBinString = "0" + negBinString;
                }
            }
        }
        
        // Decreasing for loop to carry-over binary values from the smallest power
        if (truncate) negBinString = negBinString.substring(1);
        return negBinString;
    }
}