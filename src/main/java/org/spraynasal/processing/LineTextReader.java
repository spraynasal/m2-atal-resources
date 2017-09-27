package org.spraynasal.processing;

import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * @author sebastian
 */
public class LineTextReader extends JCasCollectionReader_ImplBase {

    /**
     * File to read the data from.
     */
    public static final String INPUT_FILE = "sourceFile";
    @ConfigurationParameter(name=INPUT_FILE, mandatory = true)
    private String sourceFile;

    /**
     * Charset of source data
     */
    public static final String INPUT_CHARSET = "sourceCharset";
    @ConfigurationParameter(name=INPUT_CHARSET, mandatory = false, defaultValue = "UTF-8")
    private String charset;

    private Iterator<String> texts;

    @Override
    public void initialize(UimaContext context) throws ResourceInitializationException {
        super.initialize(context);
        try {
            texts = Files.lines(Paths.get(sourceFile), Charset.forName(charset))
                    .collect(Collectors.toList())
                    .iterator();
        } catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
    }

    @Override
    public void getNext(JCas jCas) throws IOException, CollectionException {
        jCas.setDocumentText(texts.next());
    }

    @Override
    public boolean hasNext() throws IOException, CollectionException {
        return texts.hasNext();
    }

    @Override
    public Progress[] getProgress() {
        return new Progress[0];
    }
}
