//
//    Author
//            Swopnil N. Shrestha
//            Luther College
//
//
//    Time Complexity
//            O(n2) - I tried but didn't have the time to implement anything better
//
//    Class
//            Object Oriented Programming in Java
//            Spring 2019
//
//    Instructor
//            Dr. Alan Zaring
//
//

package assignment02;

import java.util.Scanner;

public class Assignment02{
    
    
    public static void main(String [] commandLineArguments){
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of queens (a positive integer): ");
        
        int number = input.nextInt();
        
        if (number < 0){System.out.println("Not a positive integer.");}
        
        nQueensInitialize(number);
    }

//      Method static void nQueensInitialize
//        
//      Purpose
//          Acts as a container for the grid and calls the recursive solver function. 
//          Makes it simpler to implement the recursive solver, 
//          without calling it directly from the main function

    
    static void nQueensInitialize(int numberOfQueens){
//        
//        Initialize a boolean array or arrays of size n * n
//        Java by default initializes the arrays to false
//        we will use false as the default case for "values under attack"
//       
        boolean[][] grid = new boolean[numberOfQueens][numberOfQueens];
//        
//        
//        call the nQueenRecursiveSolve method to recursively solve the nQueens problem
//        call solutionPrint to print once the solution is complete
//        or to notify the user that the problem has no solution
//        
//        
        boolean solutionFound = (nQueensRecursiveSolve(numberOfQueens, grid, 0));
        if (solutionFound) {
            solutionPrint(grid, numberOfQueens);
        }
        else {
            System.out.println("No solution exists for "+numberOfQueens+" queens.");
        };    
    }

//
//    
//    Method static boolean nQueensRecursiveSolve(int numberOfQueens, boolean[][] grid, int row)
//    
//    Purpose:
//        Does the bulk of the work for the nQueens algorithm.
//        Recursively solves the nQueens problem for the specified number of 'numberOfQueens'
//        If solution is not found on the first recursion, tries the aglorithm beginning with a different row
//                
//                
//    Formals:
//        numberOfQueens (int) - the number of queens the nQueens algorithm is to solve for
//        grid (array of boolean arrays) - the grid that is used to track the changes made to the board
//        row (int) - the current row that the algorithm is being implemented on
//        
//    Pre-Conditions:
//        nQueens, grid and row must have been declared
//        
//    Post-Conditions:
//        not sure
//        
//    Time-Complexity:
//        O(n2), Since it calls 'checkForConflicts' which is an O(n) algorithm. 
//    
//    
    
    static boolean nQueensRecursiveSolve(int numberOfQueens,boolean[][] grid, int row){
//        
//        Base case. if the number of row exceeds the number of Queens, that means that
//        all the queens have been found as all rows must have a queen. 
//        End the program if base case is reached
//        
        if (row >= numberOfQueens) return true;
//        
//        For every element in every row, we see if there are any conflicts by placing a queen there
//        Once a queen is placed, we go immediately to the next row
//         
 
        int column = 0; // stands for the individual columns in the grid array
//
//        iterate through all the columns in the array
//        look at every position in the row to see if a potential solution is available
//        starting from row 0 on that specific position
//        
//        
        
        while (column < numberOfQueens){
            
            System.out.println("Trying to place queen "+(row)+" at row "+row+" column "+column);
            
            if (checkForConflicts(numberOfQueens, grid, column, row)){
                grid[column][row] = true;
//
//                call the recursive function, to look through and evaluate if a solution exists
//                if the solution does exist and the problem is solved
//                exit into the meta method through a return statement,
//                nQueensInitialize to see print the found solution
//                
                
                if (nQueensRecursiveSolve(numberOfQueens, grid, row+1)) return true;

//                Backtrack if the nQueens problem is not solved,
//                remove the last placed queen on the location      
//                solutionPrint(grid, numberOfQueens);

                grid[column][row] = false;
                System.out.println("Backtracking to re-place queen " + (row));
                
            }  
            
            System.out.println("Can't place queen "+row+" at row "+row+" column "+column+":  that square is under attack");
            
            // Go to the next column if solution does not work on this column
            ++column;
        } 
//        
//        if all the cases fail, return false. 
//        this results in the program stating that the solution does not exist
//        
        return false;
    }
    
    static boolean checkForConflicts(int numberOfQueens, boolean[][] grid, int column, int row) {  
//        
//        initialize the currentRow and currentColumn variables that will keep track of
//        the particular column and row that the algorithm is looking at
//        Check the states through and see if any queens lie at the current position
//        
        int currentRow;
        int currentColumn;

        currentRow = column;
        currentColumn = row;
        
//        
//        Condition 1
//            Check on the diagonal axis from the current position
//            to the top right corner of the grid
//            for any possible queens in those cells
//        

        while (currentRow< numberOfQueens && currentColumn>=0) {
            
            if (grid[currentRow][currentColumn] == true) {
                return false; 
            }
            
            ++currentRow;
            --currentColumn;
        }
        
//        
//        Condition 2
//          Check the column from top to down
//          Look at every row in the column and look for potential queens
//          that have been added previously
//                
//        
        
        for (currentRow = 0; currentRow < row; ++currentRow) {
            if (grid[column][currentRow] == true){ 
                return false; 
            }
        }
        
        currentRow = column;
        currentColumn = row;
                
//         
//           Condition 3
//            Check on the diagonal axis from the current position to the 
//            bottom right of the grid
//            for any possible preexisting queens
//        
//        
        while (currentRow >= 0 && currentColumn >= 0) {
            if (grid[currentRow][currentColumn] == true) {
                return false; 
            }
            
            --currentRow;
            --currentColumn;
        }
//        
//        
//        Any additional conditions are not required
//        and we only need to check these three lines
//        as anything below the currentPosition is already covered
//        and there can only be one queen on a row/column
//        
//        
        return true;
    }
    
        static void solutionPrint(boolean[][] grid, int numberOfQueens){
        for (int row = 0; row < numberOfQueens; row++) 
        { 
            for (int column = 0; column < numberOfQueens; column++) 
                if (grid[row][column]) System.out.print("<row: " + row + " column: "+column+">");
            System.out.println(); 
        } 
    }
}