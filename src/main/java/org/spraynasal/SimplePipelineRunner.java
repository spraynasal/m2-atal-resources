package org.spraynasal;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.factory.ExternalResourceFactory;
import org.apache.uima.fit.factory.TypeSystemDescriptionFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.resource.metadata.TypeSystemDescription;
import org.spraynasal.core.MD5TranslatorLocator;
import org.spraynasal.processing.LineTextReader;
import org.spraynasal.processing.LineTextWriter;
import org.spraynasal.processing.TranslateEngine;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * @author sebastian
 */
public class SimplePipelineRunner {

    public static void main(String[] args) throws IOException, UIMAException {
        Yaml yaml = new Yaml();
        Map<String, Object> config = (Map<String, Object>) yaml.load(new FileReader(new File(args[0])));

        TypeSystemDescription typesystem = TypeSystemDescriptionFactory
                .createTypeSystemDescription("translate_TS");

        // Create reader using necessary type description
        CollectionReaderDescription reader =
                CollectionReaderFactory.createReaderDescription(
                        LineTextReader.class, typesystem,
                        LineTextReader.INPUT_FILE, config.get("InputFile"));

        // Create translate engine
        AnalysisEngineDescription processor =
                AnalysisEngineFactory.createEngineDescription(TranslateEngine.class);

        // Bind resource to engine
        ExternalResourceFactory
                .bindResource(processor, TranslateEngine.TRANSLATOR, MD5TranslatorLocator.class);

        // Create writer
        AnalysisEngineDescription writer =
                AnalysisEngineFactory.createEngineDescription(
                        LineTextWriter.class,
                        LineTextWriter.OUTPUT_FILE, config.get("OutputFile"));

        // Run
        SimplePipeline.runPipeline(reader, processor, writer);
    }
}
