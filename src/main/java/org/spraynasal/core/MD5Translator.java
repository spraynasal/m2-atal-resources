package org.spraynasal.core;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

/**
 * Translates input into MD5 digest
 *
 * @author sebastian
 */
public class MD5Translator implements ITranslator {

    @Override
    public String translate(String input) {
        return Hashing.md5().hashString(input, Charsets.UTF_8).toString();
    }
}
