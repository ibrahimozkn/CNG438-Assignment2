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

                key = key.toUpperCase();

                Vigenere phaseOne = new Vigenere();

                String phaseOneCipher = phaseOne.applyPhaseOne(plainText, key);

                System.out.println("********************* Encryption *********************");
                System.out.println("Phase: Vigenere Cipher");
                System.out.println(">> Input: " + plainText);
                System.out.println(">> Key: " + key);
                System.out.println(">> Output: " + phaseOneCipher);

                ColumnarTransposition columnarTransposition = new ColumnarTransposition();

                String phaseTwoCipher = columnarTransposition.applyPhaseTwo(phaseOneCipher, key);

                System.out.println("");
                System.out.println("");
                System.out.println("Phase: Columnar Transposition Cipher");
                System.out.println(">> Input: " + phaseOneCipher);
                System.out.println(">> Key: " + key);
                System.out.println(">> Output: " + phaseTwoCipher);
                System.out.println("*****************************************************");
                System.out.println("");



            }else if(option == 2){

            }else if(option == 3){

            }else{

            }

        }while (option != 3);


    }
}