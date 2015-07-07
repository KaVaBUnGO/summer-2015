package com.game;

import java.util.List;
import java.util.Set;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public class SimpleStrategy implements Strategy {
    // TODO
    @Override
    public String getAnswer(List<String> dictionary, Set<String> usedWords, char currentLetter) {
        for (int i = 0; i < dictionary.size(); i++) {
            if ((dictionary.get(i).charAt(0) == currentLetter) && (!usedWords.contains(dictionary.get(i))))
                return dictionary.get(i);
        }
        // тут считать что обязательно есть слово в словаре?
        return null;
    }
}
