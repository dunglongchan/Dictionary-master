package sample;

public class Word {
    private String word;
    private String mean;

    public Word(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getMean() {
        return  mean;
    }
}
