package MatrixEncryption;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MatrixEncryption {
    private int size;
    private char[][] matrix;
    private String originalText;

    public MatrixEncryption(Scanner scanner, String text) {
        this.originalText=text;
        this.size=scanner.nextInt();
        matrix=new char[size][size];
        System.out.println(size);
        scanner.nextLine();
        int row=0;
        while (scanner.hasNextLine()){
            String textLine=scanner.nextLine();
            for (int i=0;i<size;i++){
                matrix[row][i]=textLine.charAt(i);
            }
            row++;
        }
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[] findPosition(char character){
        int[] position=new int[2];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if (matrix[i][j]==character){
                    position[0]=i;
                    position[1]=j;
                    return position;
                }
            }
        }
        position[0]=-1;
        position[1]=-1;
        return position;
    }

    public char returnElementAtPosition(int[] parameters){
        return matrix[parameters[0]][parameters[1]];

    }

    public String encryption(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<originalText.length()-1;i+=2){
            if (originalText.charAt(i+1)!='\n') {
                int[] positionOfFirstElement = findPosition(originalText.charAt(i));
                int[] positionOfSecondElement = findPosition(originalText.charAt(i + 1));
                if ((positionOfFirstElement[0]==-1)||(positionOfSecondElement[0]==-1)){
                    //daca una dintre pozitii este -1, atunci ambele sunt -1
                    // de asta am verificat doar pe pozitia 0
                    stringBuilder.append(originalText.charAt(i+1));
                    stringBuilder.append(originalText.charAt(i));
                    //daca unul dintre caractere nu se regaseste in text, atunci le inversez
                }
                else {
                    stringBuilder.append(matrix[positionOfFirstElement[0]][positionOfSecondElement[1]]);
                    stringBuilder.append(matrix[positionOfSecondElement[0]][positionOfFirstElement[1]]);
                }
            }
            else
                stringBuilder.append(originalText.charAt(i));
        }
        String finalText = stringBuilder.toString();
        return finalText;
    }
}
