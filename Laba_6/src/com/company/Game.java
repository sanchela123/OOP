package com.company;

import java.util.Random;

/*
 * Класс, представляющий игру в угадывание числа.
 */
public class Game {

    /*
     * Перечисление, представляющее возможные варианты состояния игры.
     */
    public enum GameState {
        ACTIVE,
        WON,
        LOST
    }

    private final int MAX_VAL; // Максимальное число для угадывания
    private final int MIN_VAL; // Минимальное число для угадывания (включительно)
    private final int MAX_ATTEMPTS; // Макс. кол-во попыток до проигрыша
    private int mTarget; // Загаданное число
    private int mAttempts; // Число использованных попыток
    private GameState mState = GameState.ACTIVE; // Текущее состояние игры

    public Game(int minVal, int maxVal, int maxAttempts) {
        if (minVal >= maxVal) {
            throw new IllegalArgumentException();
        }

        if (maxAttempts <= 0) {
            throw new IllegalArgumentException();
        }

        MIN_VAL = minVal;
        MAX_VAL = maxVal;
        MAX_ATTEMPTS = maxAttempts;

        Random random = new Random();
        mTarget = random.nextInt(MAX_VAL + MIN_VAL) - MIN_VAL;
    }

    /*
     * Попытка угадать число. Возвращает
     * число > 0, если загаданное число больше,
     * число < 0, если загаданное число меньше,
     * 0, если число угадано верно,
     * -100, если произошла ошибка.
     */
    public int guess(int number) {
        if (mState != GameState.ACTIVE) {
            return -100;
        }

        if (number < MIN_VAL || number >= MAX_VAL) {
            return -100;
        }

        mAttempts++;
        int result;
        if (number < mTarget) {
            result = 1;
        } else if (number > mTarget) {
            result = -1;
        } else {
            mState = GameState.WON;
            result = 0;
        }

        if (mAttempts == MAX_ATTEMPTS) {
            mState = GameState.LOST;
        }
        return result;
    }

    public int getMaxVal() {
        return MAX_VAL;
    }

    public int getMinValL() {
        return MIN_VAL;
    }

    public int getAttempts() {
        return mAttempts;
    }

    public int getLeftAttempts() {
        return MAX_ATTEMPTS - mAttempts;
    }

    public GameState getState() {
        return mState;
    }
}
