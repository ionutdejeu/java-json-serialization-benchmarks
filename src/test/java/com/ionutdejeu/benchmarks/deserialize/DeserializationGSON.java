package com.ionutdejeu.benchmarks.deserialize;

import org.openjdk.jmh.annotations.*;

import java.io.File;
import java.io.FileReader;
import java.util.Map.Entry;
import java.util.Set;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DeserializationGSON {

    public static String fileName = "1.json";
    @Warmup(iterations = 4)
    @Measurement(iterations = 4)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void DeserailizeTest() {
        try {
            JsonParser parser = new JsonParser();
            ClassLoader classLoader = DeserializationGSON.class.getClassLoader();
            File file = new File(classLoader.getResource(fileName).getFile());
            FileReader fileReader = new FileReader(file);

            JsonElement jsonElement = parser.parse(fileReader);
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            Set<Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
            for (Entry<String, JsonElement> entry : entrySet) {
                JsonElement value = entry.getValue();
            }
            fileReader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
