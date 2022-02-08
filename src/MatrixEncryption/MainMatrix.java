package MatrixEncryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainMatrix {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\MatrixEncryption\\matrix.txt"));


        Scanner textInput=new Scanner(new File("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\MatrixEncryption\\text.txt"));
        String text=textInput.nextLine();
        MatrixEncryption encrypt=new MatrixEncryption(input,text);

        String encryptedText=encrypt.encryption();
        System.out.println("Original text is: "+text);
        System.out.println("Encrypted text is: "+encryptedText);
    }
}
