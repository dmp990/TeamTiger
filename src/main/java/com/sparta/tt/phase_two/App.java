package com.sparta.tt.phase_two;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            JsonWriter writer = new JsonWriter("output.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}