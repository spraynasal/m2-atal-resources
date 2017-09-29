package org.spraynasal.core;

import org.apache.uima.fit.component.Resource_ImplBase;
import org.apache.uima.fit.descriptor.ExternalResourceLocator;

/**
 * @author sebastian
 */
public class MD5TranslatorLocator extends Resource_ImplBase implements ExternalResourceLocator {

    @Override
    public Object getResource() {
        return new MD5Translator();
    }
}
