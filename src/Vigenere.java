public class Vigenere {
    private static char[][] table;

    public void populateTable(){
        table = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                table[i][j] = (char) ((i + j) % 26 + 'A');
            }
        }
    }

    public String encryptPhaseOne(String plainText, String key){
        String cipherText = "";

        char[] plainTextArray = plainText.toCharArray();
        char[] keyArray = key.toCharArray();

        int keyCounter = 0;
        for(int i = 0; i < plainText.length(); i++){
            int plainTextIndex = (plainTextArray[i] - 'A');
            int keyIndex = (keyArray[keyCounter] - 'A');

            System.out.print(keyArray[keyCounter]);


            cipherText += table[keyIndex][plainTextIndex];

            if(keyCounter == key.length() - 1){
                keyCounter = 0;

            }else{
                keyCounter++;
            }


        }

        System.out.println(cipherText);




        return cipherText;
    }


    public String decryptPhaseTwo(String cipherText, String key) {
        String plainText = "";

        char[] cipherTextArray = cipherText.toCharArray();
        char[] keyArray = key.toCharArray();

        int keyCounter = 0;
        for (int i = 0; i < cipherText.length(); i++) {
            int keyIndex = (keyArray[keyCounter] - 'A');

            for(int c = 0; c < 26; c++){
                if(table[keyIndex][c] == cipherTextArray[i]){
                    plainText += (char)(c + 'A');
                }
            }

            if (keyCounter == key.length() - 1) {
                keyCounter = 0;

            } else {
                keyCounter++;
            }
        }

        return plainText;
    }

    public Vigenere(){
        populateTable();
    }
}
