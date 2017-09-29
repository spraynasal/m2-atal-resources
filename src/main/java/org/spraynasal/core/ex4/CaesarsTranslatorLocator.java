package org.spraynasal.core.ex4;

import org.apache.uima.fit.component.Resource_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.descriptor.ExternalResourceLocator;

/**
 * @author sebastian
 */
public class CaesarsTranslatorLocator extends Resource_ImplBase implements ExternalResourceLocator {

    public static final String SHIFT = "Shift";

    @ConfigurationParameter(name = SHIFT)
    protected Integer shift;

    @Override
    public Object getResource() {
        return new CaesarsTranslator(shift);
    }
}
