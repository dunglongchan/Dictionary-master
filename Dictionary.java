package sample;
import java.util.ArrayList;

public class Dictionary {
    public ArrayList<Word> list = new ArrayList<>();

    public void add(Word a) {
        list.add(a);
    }

    public void delete(String a) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWord().equals(a)) {
                list.remove(i);
            }
        }

    }

    public String getWordinList(int n) {
        return list.get(n).getWord();
    }

    public String getMeaninList(int n) {
        return list.get(n).getMean();
    }

    public void fix(String word, String input) {
        for (int i = 0; i < list.size(); i++) {
            if(getWordinList(i).equals(word) == true) {
                list.get(i).setMean(input);
            }
        }
    }
}