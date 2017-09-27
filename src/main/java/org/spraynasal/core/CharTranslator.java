package org.spraynasal.core;

/**
 * @author sebastian
 */
public abstract class CharTranslator implements ITranslator {

    public abstract Character translate(Character character);

    @Override
    public String translate(String input) {
        StringBuilder outBuilder = new StringBuilder();
        for(int i = 0; i < input.length(); i++) {
            outBuilder.append(new Character(input.charAt(i)));
        }
        return outBuilder.toString();
    }
}
