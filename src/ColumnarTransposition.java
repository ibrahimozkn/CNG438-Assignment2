import java.util.*;

public class ColumnarTransposition {
    public String encryptPhaseTwo(String plainText, String key){
        String cipherText = "";

        int row = (int) Math.ceil((double) plainText.length() / key.length());

        char[] plainArray = plainText.toCharArray();


        char[][] table = new char[row][key.length()];

        int plainIndex = 0;
        for(int c = 0; c < key.length(); c++){
            for(int r = 0; r < row; r++){
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

        char[][] table = new char[row][key.length()];


        int cipherIndex = 0;
        for(int c = 0; c < key.length(); c++){
            for(int r = 0; r < row; r++){
                if(cipherIndex > cipherText.length() - 1){
                    table[r][c] = '0';
                }else {
                    table[r][c] = cipherArray[cipherIndex];
                }

                cipherIndex++;

            }

        }

        List<WordIndex> wordIndexList = new ArrayList<>();

        for(int i = 0; i < key.length(); i++){
            wordIndexList.add(new WordIndex(i, key.charAt(i)));
        }

        findSortedIndex(wordIndexList);


        for(int w = 0; w < wordIndexList.size(); w++){
            for(int r = 0; r < row; r++){
                plainText += table[r][wordIndexList.get(w).index];
            }
        }



        return plainText;
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

    private void findSortedIndex(List<WordIndex> wordIndexList){
        WordIndex[] wordIndexArray = wordIndexList.toArray(new WordIndex[0]);
        for (int i = 0; i < wordIndexArray.length - 1; i++) {
            for (int j = i + 1; j < wordIndexArray.length; j++) {
                if (wordIndexArray[i].word > wordIndexArray[j].word) {
                    WordIndex temp = wordIndexArray[i];
                    wordIndexArray[i] = wordIndexArray[j];
                    wordIndexArray[j] = temp;
                }
            }
        }

        for (int i = 0; i < wordIndexArray.length; i++) {
            wordIndexArray[i].index = i;
        }

        wordIndexList = Arrays.asList(wordIndexArray);
    }




}
