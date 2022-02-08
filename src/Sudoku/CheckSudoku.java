package Sudoku;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CheckSudoku {
    final int gridDimension=9;
    public int[][] sudokuGrid;
    private int[] rowDigits;
    private int[] columnDigits;
    private int[] squareDigits;

    public CheckSudoku(Scanner scanner) {
        sudokuGrid=new int[gridDimension][gridDimension];
        int row=0;
        while(scanner.hasNextInt()){
            for (int i=0;i<gridDimension;i++){
                sudokuGrid[row][i]=scanner.nextInt();
            }
            row++;
        }
        for (int i=0;i<gridDimension;i++){
            for (int j=0;j<gridDimension;j++){
                System.out.print(sudokuGrid[i][j]+" ");
            }
            System.out.println();
        }
        rowDigits=new int[gridDimension];
        for (int i=0;i<gridDimension;i++)
            rowDigits[i]=0;
        columnDigits=new int[gridDimension];
        for (int i=0;i<gridDimension;i++)
            columnDigits[i]=0;
        squareDigits=new int[gridDimension];
        for (int i=0;i<gridDimension;i++)
            columnDigits[i]=0;
        scanPopulatedValues();
        /*if (solveSudoku(0,0)){
            try {
                PrintWriter fileout = new PrintWriter(new FileWriter("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\Sudoku\\output.txt"));
                for (int i = 0; i < gridDimension; i++) {
                    for (int j=0;j<gridDimension;j++) {
                        fileout.print(sudokuGrid[i][j]+" ");
                    }
                    fileout.println();
                }
                fileout.close();
                System.out.println();
                System.out.println("Solution to sudoku:");
                printGrid(sudokuGrid);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else
            System.out.println("No solution exists");*/
        if (checkSudoku())
            System.out.println("Sudoku este rezolvat corect");
        else
            System.out.println("Sudoku este gresit");

    }
    private void scanPopulatedValues() {
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                if (sudokuGrid[i][j] != 0) {
                    int m = sudokuGrid[i][j] ;
                    columnDigits[j] |=(1 << (m-1));
                    rowDigits[i] |= (1 << (m-1));
                    squareDigits[(i / 3) * 3 + j / 3]  |= (1 << (m-1));
                }
            }
        }
    }

    public boolean checkSudoku(){
        int number= rowDigits[0];
        for (int i=0;i<gridDimension;i++){
            if ((rowDigits[i]!=number)&&(columnDigits[i]!=number)&&(squareDigits[i]!=number)) {
                return false;
            }
        }
        return true;
    }


    private boolean solveSudoku(int row, int column) {
        if ((row == (gridDimension - 1)) && (column == gridDimension)) {
            return true;
        }
        if (column == gridDimension) {
            row++;
            column = 0;
        }
        if (sudokuGrid[row][column] != 0)
            return solveSudoku(row, column + 1);
        for (int number = 1; number < 10; number++) {
            if (isPossible(row, column, number)) {
                sudokuGrid[row][column] = number;
                squareDigits[(row / 3) * 3 + column / 3] |= 1 << (number - 1);
                rowDigits[row] |= 1 << (number - 1);
                columnDigits[column] |= 1 << (number - 1);
                if (solveSudoku(row, column + 1))
                    return true;
                else{
                    sudokuGrid[row][column] = 0;
                    squareDigits[(row / 3) * 3 + column / 3] ^= (1<<(number-1));
                    rowDigits[row] ^= (1<<(number-1));
                    columnDigits[column] ^= (1<<(number-1));
                }
            }
        }
        return false;
    }

    private boolean isPossible(int row, int column, int number){
        int r= rowDigits[row];

        int c=columnDigits[column];
        int s=squareDigits[(row / 3) * 3 + column / 3];
        if (((r & (1<<(number -1)))==0)&&
                (((c & (1<<(number-1)))==0))&&
                ((s & (1<<(number-1 )))==0))
            return true;
        else
            return false;
    }

    public void printGrid(int[][] grid){
        for (int i=0;i<gridDimension;i++){
            for (int j=0;j<gridDimension;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "CheckSudoku{" +
                "gridDimension=" + gridDimension +
                ", sudokuGrid=" + Arrays.toString(sudokuGrid) +
                ", rowDigits=" + Arrays.toString(rowDigits) +
                ", columnDigits=" + Arrays.toString(columnDigits) +
                ", squareDigits=" + Arrays.toString(squareDigits) +
                '}';
    }
}
