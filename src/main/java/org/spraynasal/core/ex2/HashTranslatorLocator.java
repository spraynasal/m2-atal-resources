package org.spraynasal.core.ex2;

import org.apache.uima.fit.component.Resource_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.ExternalResourceLocator;

/**
 * @author sebastian
 */
public class HashTranslatorLocator extends Resource_ImplBase implements ExternalResourceLocator {

    public static final String HASH_FUNCTION = "HashFunction";

    @ConfigurationParameter(name = HASH_FUNCTION)
    protected String hashFunc;

    @Override
    public Object getResource() {
        return new HashTranslator(HashFunc.valueOf(hashFunc));
    }
}
