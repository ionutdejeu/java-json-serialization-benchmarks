package com.ionutdejeu.benchmarks.deserialize;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.util.Set;

public class DeserializationJsonp {
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
            JsonReader reader = Json.createReader(fileReader);
            JsonObject readObject = reader.readObject();
            Set<String> keySet = readObject.keySet();
            for(String key : keySet){
                JsonValue jsonValue = readObject.get(key);
            }
            fileReader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
