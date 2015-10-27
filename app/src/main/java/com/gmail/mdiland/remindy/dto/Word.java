package com.gmail.mdiland.remindy.dto;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Max Diland.
 */

public class Word {
    private static final long ONE_LONG = 1L;

    private String root;
    private List<String> endings;
    private WordType type;
    private Set<WordMeaning> meanings;
    private Integer numericValue;

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public List<String> getEndings() {
        return Collections.unmodifiableList(endings);
    }

    public void setEndings(List<String> endings) {
        this.endings = endings;
    }

    public Set<WordMeaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(Set<WordMeaning> meanings) {
        this.meanings = meanings;
    }

    public WordType getType() {
        return type;
    }

    public void setType(WordType type) {
        this.type = type;
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public void setNumericValue(Integer numericValue) {
        this.numericValue = numericValue;
    }

    public Set<String> getWordVariants() {
        String rootLowerCase = root.toLowerCase();
        if (endings == null) {
            return Collections.singleton(rootLowerCase);
        }

        Set<String> index = new HashSet<>(endings.size(), ONE_LONG);
        for (String ending : endings) {
            String endingLowerCase = ending.toLowerCase();
            index.add( rootLowerCase + endingLowerCase );
        }
        return index;
    }

    @Override
    public boolean equals(Object that) {
        if (that == this) return true;
        if (that instanceof CharSequence) {
            return equalsCharSequence( (CharSequence)that );
        }
        return false;
    }

    private boolean equalsCharSequence(CharSequence that) {
        return getWordVariants().contains( that.toString().toLowerCase() );
    }
}
