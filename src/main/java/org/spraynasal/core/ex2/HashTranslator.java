package org.spraynasal.core.ex2;

import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import org.spraynasal.core.ITranslator;

import java.util.Objects;

/**
 * Translates input into digest by given hash function
 *
 * @author sebastian
 */
public class HashTranslator implements ITranslator {

    private final HashFunction hasher;

    public HashTranslator(HashFunc fun) {
        Objects.requireNonNull(fun);
        hasher = fun.getFunct();
    }

    @Override
    public String translate(String input) {
        return hasher.hashString(input, Charsets.UTF_8).toString();
    }
}
