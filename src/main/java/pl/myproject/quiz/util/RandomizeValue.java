/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.myproject.quiz.util;

import static java.lang.Math.random;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Mariusz Czarny
 */
public final class RandomizeValue {

    /**
     *
     * @param startYear
     * @return
     */
    public static int getRandomYear(int startYear) {
        return (int) (random() * 50 + startYear);
    }
    
    /**
     *
     * @return
     */
    public static Date getRandomData() {
        Random random = new Random();
        return new Date(Math.abs(System.currentTimeMillis() - random.nextLong()));
    }
    
    /**
     *
     * @param paramsArray
     * @return
     */
    public static String getRandomString(String[] paramsArray) {
        return paramsArray[(int) (random() * paramsArray.length)];
    }

    /**
     *
     * @param size
     * @return
     */
    public static int getRandomInt(int size) {
        return (int) (random() * size);
    }
    
    /**
     *
     * @return
     */
    public static boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
