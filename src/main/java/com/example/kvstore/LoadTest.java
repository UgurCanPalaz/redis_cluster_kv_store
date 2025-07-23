package com.example.kvstore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoadTest {

    public static void main(String[] args) throws Exception {
        int threads = 10;  // Aynı anda kaç paralel işlem olacak
        int operationsPerThread = 1000;  // Her thread kaç set/get yapacak

        KeyValueStore store = new KeyValueStore();
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        long start = System.currentTimeMillis();

        for (int i = 0; i < threads; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < operationsPerThread; j++) {
                    String key = "key-" + threadId + "-" + j;
                    String value = "value-" + j;

                    store.set(key, value);
                    String val = store.get(key);

                    if (!value.equals(val)) {
                        System.err.println("Data mismatch for key: " + key);
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            Thread.sleep(100);
        }

        long end = System.currentTimeMillis();
        System.out.println("Load test completed in " + (end - start) + " ms");

        store.close();
    }
}
