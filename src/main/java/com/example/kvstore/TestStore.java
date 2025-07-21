package com.example.kvstore;

public class TestStore {

    public static void main(String[] args) {
        System.out.println("Application started");
        KeyValueStore store = new KeyValueStore();
        store.set("username", "neira");
        String username = store.get("username");
        if ("neira".equals(username)) {
            System.out.println("Test successful: username = " + username);
        } else {
            System.err.println("Test failed: expected 'neira' but got " + username);
        }
    }
}
