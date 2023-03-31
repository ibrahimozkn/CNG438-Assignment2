public class Vigenere {
    private static final char[][] table = {

            {'M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A',},
            {'B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M',},
            {'C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B',},
            {'D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C',},
            {'F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D',},
            {'E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F',},
            {'G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E',},
            {'H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G',},
            {'K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H',},
            {'J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K',},
            {'I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J',},
            {'S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I',},
            {'Z','N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S',},
            {'N','O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z',},
            {'O','P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N',},
            {'P','Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O',},
            {'Q','R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P',},
            {'R','L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q',},
            {'L','T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R',},
            {'T','U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L',},
            {'U','X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T',},
            {'X','W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U',},
            {'W','V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X',},
            {'V','Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W',},
            {'Y','A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V',},
            {'A','M','B','C','D','F','E','G','H','K','J','I','S','Z','N','O','P','Q','R','L','T','U','X','W','V','Y',},

    };

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

    }
}
