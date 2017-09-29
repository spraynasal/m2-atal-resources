package org.spraynasal.core.ex3;

import org.spraynasal.core.CharTranslator;

/**
 * @author sebastian
 */
public class ShiftTranslator extends CharTranslator {

    @Override
    public Character translate(Character character) {
        return (char) (character.charValue() + 1);
    }
}
