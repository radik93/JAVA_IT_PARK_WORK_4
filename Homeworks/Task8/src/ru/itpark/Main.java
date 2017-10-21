package ru.itpark;

public class Main {

    public static void main(String[] args) {

        Parser parser = Parser.bilder()
                .outputDigits(new OutputDigits())
                .outputLetters(new OutputLetters())
                .outputGap(new OutputGap())
                .build();
        parser.parse("Hi 1!");
    }
}
