package src.M1;

import java.util.HashMap;
import java.util.Map;

public class CharacterData {
    private int total;
    Map<Character, Integer> characterCount;

    public CharacterData() {
        this.total = 0;
        this.characterCount = new HashMap<Character, Integer>();
    }

    public void addWord(String word) {
        for(char c : word.toCharArray()) {
            for(int i = 97; i <= 122; i++) {
                if(c == (char)i) {
                    int count = 1;

                    if(this.characterCount.get((char) i) != null) {
                        count = this.characterCount.get((char) i) + 1;
                    }

                    this.characterCount.put((char) i, count);

                    break;
                }
            }
        }

        this.total += word.length();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Map<Character, Integer> getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(Map<Character, Integer> characterCount) {
        this.characterCount = characterCount;
    }
}
