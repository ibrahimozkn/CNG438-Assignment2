import java.util.*;

public class ColumnarTransposition {
    public String applyPhaseTwo(String plainText, String key){
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

        Collections.sort(wordIndexList, (Comparator<WordIndex>) (w1, w2) -> Character.compare(w1.word, w2.word));


        for(int w = 0; w < wordIndexList.size(); w++){
            for(int r = 0; r < row; r++){
                cipherText += table[r][wordIndexList.get(w).index];
            }
        }

        return cipherText;
    }

}
