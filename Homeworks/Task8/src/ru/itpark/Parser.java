package ru.itpark;

public class Parser implements Observable {
    private OutputDigits outputDigits;
    private OutputLetters outputLetters;
    private OutputGap outputGap;

    private Observer[] observers = new Observer[3];
    private int count = 0;


    @Override
    public void eventAddText(String Text) {
        char chars[] = Text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            notifyAll(chars[i]);
        }
    }

    // @Override
    //public void addObserver(Parser parser) {
    //  if(parser.outputDigits != null)
    ///    observers[count] = outputDigits;

    //}

    public static class Bilder {
        private OutputDigits outputDigits;
        private OutputLetters outputLetters;
        private OutputGap outputGap;
        private Observer observers[];

        public Bilder outputDigits(OutputDigits outputDigits) {
            this.outputDigits = outputDigits;
            return this;
        }

        public Bilder outputLetters(OutputLetters outputLetters) {
            this.outputLetters = outputLetters;
            return this;
        }

        public Bilder outputGap(OutputGap outputGap) {
            this.outputGap = outputGap;
            return this;
        }

        public Parser build() {
            return new Parser(this);
        }

    }

    private Parser(Bilder bilder) {
        //  this.outputDigits = bilder.outputDigits;
        //  this.outputLetters = bilder.outputLetters;
        //  this.outputGap = bilder.outputGap;
        if (bilder.outputDigits != null) {
            this.observers[count] = bilder.outputDigits;
            count++;
        }
        if (bilder.outputLetters != null) {
            this.observers[count] = bilder.outputLetters;
            count++;
        }
        if (bilder.outputGap != null) {
            this.observers[count] = bilder.outputGap;
            count++;
        }
    }

    public static Bilder bilder() {
        return new Bilder();
    }

    public void parse(String Text) {
        eventAddText(Text);
    }

    public void notifyAll(char c) {
        for (int i = 0; i < observers.length; i++) {
            observers[i].handleEvent(c);
        }
    }
}
