package com.example;

import java.lang.String;
import java.util.Random;

public class Jokes {

    public static final String[] JOKES = {"Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.", "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.",
            "If i had a dollar for every girl that found me unattractive, they would eventually find me attractive.", "That awkward moment when you leave a store without buying anything and all you can think is act natural, you're innocent"};

    public static String LetsLaugh() {
        Random random = new Random();
        System.out.println("string" + random.nextInt(JOKES.length));
        return JOKES[random.nextInt(JOKES.length)];
    }
}
