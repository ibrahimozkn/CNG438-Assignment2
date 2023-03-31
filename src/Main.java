import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option;
        do{
            System.out.println("Simple Cipher:");
            System.out.println("[1] Encrypt");
            System.out.println("[2] Decrypt");
            System.out.println("[3] Exit");
            System.out.println("Selection: ");
            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 1){
                System.out.println("Enter the plain text message: ");
                String plainText = scanner.nextLine();

                plainText = plainText.replaceAll("\\s+", "").toUpperCase();


                String key;
                do {
                    System.out.println("Enter the key: ");
                    key = scanner.nextLine();

                    if(key.length() > plainText.length()){
                        System.out.println("Key length cannot be longer than plaintext length");
                    }

                }while (key.length() > plainText.length());

                key = key.replaceAll("\\s+", "").toUpperCase();

                Vigenere phaseOne = new Vigenere();

                String phaseOneCipher = phaseOne.encryptPhaseOne(plainText, key);

                System.out.println("********************* Encryption *********************");
                System.out.println("Phase: Vigenere Cipher");
                System.out.println(">> Input: " + plainText);
                System.out.println(">> Key: " + key);
                System.out.println(">> Output: " + phaseOneCipher);

                ColumnarTransposition columnarTransposition = new ColumnarTransposition();

                String phaseTwoCipher = columnarTransposition.encryptPhaseTwo(phaseOneCipher, key);

                System.out.println("");
                System.out.println("");
                System.out.println("Phase: Columnar Transposition Cipher");
                System.out.println(">> Input: " + phaseOneCipher);
                System.out.println(">> Key: " + key);
                System.out.println(">> Output: " + phaseTwoCipher);
                System.out.println("*****************************************************");
                System.out.println("");



            }else if(option == 2){
                System.out.println("Enter the cipher text message: ");
                String cipherText = scanner.nextLine();

                cipherText = cipherText.replaceAll("\\s+", "").toUpperCase();


                String key;
                do {
                    System.out.println("Enter the key: ");
                    key = scanner.nextLine();

                    if(key.length() > cipherText.length()){
                        System.out.println("Key length cannot be longer than ciphertext length");
                    }

                }while (key.length() > cipherText.length());

                key = key.replaceAll("\\s+", "").toUpperCase();

                ColumnarTransposition columnarTransposition = new ColumnarTransposition();

                String phaseOneDecrypt = columnarTransposition.decryptPhaseOne(cipherText, key);

                System.out.println("********************* Decryption *********************");
                System.out.println("Phase: Columnar Transposition Cipher");
                System.out.println(">> Input: " + cipherText);
                System.out.println(">> Key: " + key);
                System.out.println(">> Output: " + phaseOneDecrypt);


                Vigenere vigenere = new Vigenere();


                String phaseTwoDecrypt = vigenere.decryptPhaseTwo(phaseOneDecrypt, key);


                System.out.println("");
                System.out.println("");
                System.out.println("Phase: Columnar Transposition Cipher");
                System.out.println(">> Input: " + phaseOneDecrypt);
                System.out.println(">> Key: " + key);
                System.out.println(">> Output: " + phaseTwoDecrypt);
                System.out.println("*****************************************************");
                System.out.println("");

            }else if(option == 3){

            }else{

            }

        }while (option != 3);


    }
}