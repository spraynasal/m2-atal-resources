package org.spraynasal.core.ex4;

import org.spraynasal.core.CharTranslator;

/**
 * @author sebastian
 */
public class CaesarsTranslator extends CharTranslator {

    private final int increment;

    public CaesarsTranslator(int increment) {
        this.increment = increment;
    }

    @Override
    public Character translate(Character character) {
        return (char) (character.charValue() + increment);
    }
}
