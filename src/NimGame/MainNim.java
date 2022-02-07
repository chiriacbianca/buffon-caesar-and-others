package NimGame;

import java.util.Scanner;

public class MainNim {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("How many stacks do you want to play with? ");
        int number = scanner.nextInt();
        Nim nimGame= new Nim(number);
    }
}
