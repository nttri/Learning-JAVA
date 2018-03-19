package pkg;

import java.io.Serializable;

/**
 *
 * @author thanhtri-1512605
 */
public class Word implements Serializable {
    private String word;
    private String meaning;
    private int nSearch;
    private Boolean isFavorite;
    
    public Word() {
        this.word = "";
        this.meaning = "";
        this.nSearch = 0;
        this.isFavorite = false;
    }

    public Word(String word, String meaning, int nSearch, Boolean isFavorite) {
        this.word = word;
        this.meaning = meaning;
        this.nSearch = nSearch;
        this.isFavorite = isFavorite;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getnSearch() {
        return nSearch;
    }

    public void setnSearch(int nSearch) {
        this.nSearch = nSearch;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
    
}
