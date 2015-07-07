package com.game;

import java.util.List;
import java.util.Set;

/**
 * Created by Artur Chernov on 28.06.15.
 */
public interface Strategy {
    public String getAnswer(List<String> dictionary, Set<String> usedWords, char currentLetter);
}
