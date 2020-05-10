package com.ionutdejeu.benchmarks;

import com.ionutdejeu.benchmarks.deserialize.DeserializationGSON;
import com.ionutdejeu.benchmarks.deserialize.DeserializationJackson;
import com.ionutdejeu.benchmarks.deserialize.DeserializationJsonp;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(DeserializationGSON.class.getSimpleName())
                .include(DeserializationJackson.class.getSimpleName())
                .include(DeserializationJsonp.class.getSimpleName())
                .forks(1)
                .jvmArgsAppend("-Djava.io.temdir=C:\\temp")
                .build();
        new Runner(opt).run();


    }
}
