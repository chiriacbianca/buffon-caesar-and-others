package Sudoku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainSudoku {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner= new Scanner(new File("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\Sudoku\\inputMatrix.txt"));
        CheckSudoku checker= new CheckSudoku(scanner);
    }
}
