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
    private String root;
    private List<String> endings;
    private WordType type;
    private Set<WordMeaning> meanings;
    private Set<String> index;

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
        buildIndex();
    }

    public Set<WordMeaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(Set<WordMeaning> meanings) {
        this.meanings = meanings;
    }

    private void buildIndex() {
        String rootLowerCase = root.toLowerCase();
        Set<String> index = new HashSet<>();
        for (String ending : endings) {
            String endingLowerCase = ending.toLowerCase();
            index.add( rootLowerCase + endingLowerCase );
        }
        this.index = index;
    }

    public Collection<String> getIndex() {
        if (index != null) {
            return Collections.unmodifiableCollection(index);
        } else {
            return Collections.singleton(root);
        }
    }

    public WordType getType() {
        return type;
    }

    public void setType(WordType type) {
        this.type = type;
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
        return index.contains( that.toString().toLowerCase() );
    }
}
