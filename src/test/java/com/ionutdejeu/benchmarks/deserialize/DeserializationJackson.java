package com.ionutdejeu.benchmarks.deserialize;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

public class DeserializationJackson {
    public static String fileName = "1.json";
    @Warmup(iterations = 4)
    @Measurement(iterations = 4)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void DeserailizeTest() {
        try {

            ClassLoader classLoader = DeserializationGSON.class.getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            FileReader fileReader = new FileReader(file);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(fileReader);
            Iterator<JsonNode> ite = rootNode.iterator();
            while (ite.hasNext()) {
                JsonNode temp = ite.next();
            }
            fileReader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
