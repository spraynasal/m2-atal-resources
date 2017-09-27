package org.spraynasal.processing;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ExternalResource;
import org.apache.uima.jcas.JCas;
import org.spraynasal.core.ITranslator;
import org.spraynasal.uima.ts.TranslatedTextBlock;

/**
 * @author sebastian
 */
public class TranslateEngine extends JCasAnnotator_ImplBase {

    public static final String TRANSLATOR = "translator";
    @ExternalResource(key = TRANSLATOR)
    ITranslator translator;

    @Override
    public void process(JCas aJCas) throws AnalysisEngineProcessException {
        TranslatedTextBlock block = new TranslatedTextBlock(aJCas);
        String sourceText = aJCas.getDocumentText();
        block.setBegin(0);
        block.setEnd(sourceText.length());
        block.setTranslation(translator.translate(sourceText));
        block.addToIndexes();
    }
}
