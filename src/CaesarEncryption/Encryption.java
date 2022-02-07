package CaesarEncryption;

public class Encryption {
    private char alphabet[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};

    public Encryption() {
    }

    public String encryptText(String text, int[] key, boolean encryptOrDecrypt) {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(alphabet.length);
        int step;
        for (int i = 0; i < text.length(); i++) {
            if (encryptOrDecrypt == true) {
                step = key[i] % (alphabet.length - 1);
            } else {
                step = alphabet.length - 1 - key[i] % (alphabet.length - 1);
            }
            /*System.out.println("Step: "+step);
            System.out.println(i);
            System.out.println(i+step);*/
                int position = searchPosition(text.charAt(i));
                if (position != -1) {
                    if (position + step < alphabet.length - 1) {
                        stringBuilder.append(alphabet[position + step]);
                    } else
                        stringBuilder.append(alphabet[position + step - (alphabet.length - 1)]);
                } else {
                    stringBuilder.append(text.charAt(i));
                }
            }
            String finalText = stringBuilder.toString();
            return finalText;
        }

        public int searchPosition ( char character){
            for (int i = 0; i < alphabet.length - 1; i++) {
                if (character == alphabet[i])
                    return i;
            }
            return -1;
        }
}

