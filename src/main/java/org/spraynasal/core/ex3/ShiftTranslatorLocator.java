package org.spraynasal.core.ex3;

import org.apache.uima.fit.component.Resource_ImplBase;
import org.apache.uima.fit.descriptor.ExternalResourceLocator;

/**
 * @author sebastian
 */
public class ShiftTranslatorLocator extends Resource_ImplBase implements ExternalResourceLocator {

    @Override
    public Object getResource() {
        return new ShiftTranslator();
    }
}
