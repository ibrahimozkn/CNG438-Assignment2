import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ColumnarTransposition {
    public String encryptPhaseTwo(String plainText, String key){
        String cipherText = "";

        int row = (int) Math.ceil((double) plainText.length() / key.length());

        char[] plainArray = plainText.toCharArray();


        char[][] table = new char[row][key.length()];

        int plainIndex = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < key.length(); c++){
                if(plainIndex > plainText.length() - 1){
                    table[r][c] = '0';
                }else {
                    table[r][c] = plainArray[plainIndex];
                }

                plainIndex++;
            }


        }

        List<WordIndex> wordIndexList = new ArrayList<>();

        for(int i = 0; i < key.length(); i++){
            wordIndexList.add(new WordIndex(i, key.charAt(i)));
        }

        sortWord(wordIndexList);

        for(int w = 0; w < wordIndexList.size(); w++){
            for(int r = 0; r < row; r++){
                cipherText += table[r][wordIndexList.get(w).index];
            }
        }

        return cipherText;
    }


    public String decryptPhaseOne(String cipherText, String key){
        String plainText = "";

        int row = (int) Math.ceil((double) cipherText.length() / key.length());

        char[] cipherArray = cipherText.toCharArray();

        List<Character> keyList = new ArrayList<Character>();
        for(char c : key.toCharArray()) {
            keyList.add(c);
        }



        char[] sortedKeys = key.toCharArray();
        Arrays.sort(sortedKeys);

        List<Character> sortedKeysList = new ArrayList<Character>();
        for(char c : sortedKeys) {
            sortedKeysList.add(c);
        }

        char[][] orderTable = new char[row][key.length()];


        int index = 0;
        for(int column = 0; column < key.length(); column++){
            int col = keyList.indexOf(sortedKeysList.get(column));

            for(int r = 0; r < row; r++){
                if(index > cipherText.length() - 1) {
                    orderTable[r][col] = '0';
                }else {
                    orderTable[r][col] = cipherArray[index];

                }
                index++;
            }
        }

        for(int r = 0; r < row; r++){
            for(int c = 0; c < key.length(); c++){
                plainText += orderTable[r][c];
            }
        }



        return plainText.replaceAll("0", "");
    }

    private void sortWord(List<WordIndex> wordIndexList){
        for(int i = 0; i < wordIndexList.size(); i++){
            for(int j = 0; j < wordIndexList.size(); j++){
                if(wordIndexList.get(i).word < wordIndexList.get(j).word){
                    WordIndex temp = wordIndexList.get(i);
                    wordIndexList.set(i, wordIndexList.get(j));
                    wordIndexList.set(j, temp);
                }
            }
        }
    }





}
