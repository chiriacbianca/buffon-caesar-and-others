package CaesarEncryption;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class CaesarMain {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\CaesarEncryption\\input.txt"));
        String data=null;
        while (input.hasNextLine()) {
            data = input.nextLine();
            System.out.println(data);
        }

        int numberOfRandomValues=10000;

        Random rand= new Random(System.currentTimeMillis());
        try {
            PrintWriter fileout = new PrintWriter(new FileWriter("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\CaesarEncryption\\key.txt"));

            for (int i = 0; i < numberOfRandomValues; i++) {
                int number=rand.nextInt(1000);
                fileout.println(number);
            }
            fileout.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        int key[]= new int[numberOfRandomValues];
        Scanner readKey=new Scanner(new File("C:\\Users\\bianca info\\IdeaProjects\\com.CapSpecJ\\src\\CaesarEncryption\\key.txt"));
        for (int i=0;i<numberOfRandomValues;i++){
            key[i]=readKey.nextInt();
            System.out.print(key[i]+" ");
        }
        System.out.println();

        Encryption text=new Encryption();
        String encryptedText=text.encryptText(data,key,true);
        System.out.println("Encrypted text is:"+encryptedText);
        String decryptedText=text.encryptText(encryptedText,key,false);
        System.out.println("Decrypted text is: "+decryptedText);
    }
}
