package org.spraynasal.processing;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasConsumer_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.spraynasal.uima.ts.TranslatedTextBlock;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author sebastian
 */
public class LineTextWriter extends JCasConsumer_ImplBase {

    /**
     * File to write the data to.
     */
    public static final String OUTPUT_FILE = "destFile";
    @ConfigurationParameter(name=OUTPUT_FILE, mandatory = true)
    private String destFile;

    private FileWriter fileWriter;

    @Override
    public void initialize(UimaContext context) throws ResourceInitializationException {
        super.initialize(context);
        try {
            fileWriter = new FileWriter(new File(destFile));
        } catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
    }

    @Override
    public void process(JCas aJCas) throws AnalysisEngineProcessException {
        TranslatedTextBlock block = JCasUtil.select(aJCas, TranslatedTextBlock.class)
                .stream()
                .findFirst()
                .orElseThrow(() -> new AnalysisEngineProcessException("No translation found", null));
        try {
            fileWriter.write(block.getTranslation());
            fileWriter.write('\n');
        } catch (IOException e) {
            throw new AnalysisEngineProcessException(e);
        }
    }

    @Override
    public void collectionProcessComplete() throws AnalysisEngineProcessException {
        super.collectionProcessComplete();
        try {
            fileWriter.close();
        } catch (IOException e) {
            new AnalysisEngineProcessException(e);
        }
    }
}
