import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandline {
    static DictionaryManagement myDictionary = new DictionaryManagement();

    public static void showAllWords() throws IOException {
        System.out.println("No | English | Vietnamese");
        int n = myDictionary.dictionary.size();
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + " | " + myDictionary.dictionary.getWordinList(i) +
                                " | " + myDictionary.dictionary.getMeaninList(i));
        }
    }

    public static void dictionaryBasic() throws Exception {
        myDictionary.insertFromCommandline();
        showAllWords();
    }

    public static void dictionaryAdvanced() throws Exception {
        myDictionary.insertFromFile();
        showAllWords();
        myDictionary.dictionaryLookup();
    }

    public static void dictionarySearcher() throws IOException {
        //myDictionary.insertFromFile();
        //showAllWords();
        Scanner sc = new Scanner(System.in);
        String keyWord = sc.nextLine();
        int count = 0;
        for(int i = 0; i < myDictionary.dictionary.size(); i++) {
            if (testString(keyWord, myDictionary.dictionary.getWordinList(i))) {
                System.out.println(myDictionary.dictionary.getWordinList(i));
            }
            else count++;
        }
        if(count == myDictionary.dictionary.size()) System.out.println("No word in Dictionary");
    }

    public static boolean testString(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        if (count == n) return true;
        else return false;
    }

    public static void main(String[] args) throws Exception {
        //DictionaryManagement dm = new DictionaryManagement();
        myDictionary.insertFromFile();
        showAllWords();
        myDictionary.dictionaryExportToFile();
        showAllWords();
        //myDictionary.dictionaryLookup();
        //myDictionary.dictionaryExportToFile();
        dictionarySearcher();
        //dictionaryAdvanced();
        //showAllWords();

    }
 

}
