package com.company;

import java.util.*;

public class Game {

    public enum DeckType{
        DECK_36(9),
        DECK_54(13);

        final int mNumberOfCards;

        DeckType(int numberOfCards){
            mNumberOfCards = numberOfCards;
        }
    }

    public enum GameState{
        ACTIVE,
        FINISHED,
        DRAW
    }


    private DeckType mDeckType;
    private final int MAX_STEPS;
    private GameState mState = GameState.ACTIVE; // Состояние игры
    private int mCurrentStep = 0; // Текущий шаг
    private Queue<Integer> mQueue1 = new ArrayDeque<>(64); // Карты первого игрока
    private Queue<Integer> mQueue2 = new ArrayDeque<>(64); // Карты второго игрока
    private Queue<Integer> mBattleQueue = new ArrayDeque<>(16); // Карты на столе

    public Game(DeckType deckType, int maxSteps) {
        if(deckType == null){
            throw new IllegalArgumentException();
        }

        if(maxSteps <= 0){
            throw new IllegalArgumentException();
        }

        mDeckType = deckType;
        MAX_STEPS = maxSteps;
        List<Integer> deck = getNewShuffledDeck();
        for (int i = 0; i < deck.size(); i++){
            if(i % 2 == 0) {
                mQueue1.add(deck.get(i));
            } else {
                mQueue2.add(deck.get(i));
            }
        }
    }

    public Game(DeckType deckType, int maxSteps, String deck1, String deck2){
        if(deckType == null){
            throw new IllegalArgumentException();
        }

        if(deck1 == null || deck2 == null){
            throw new IllegalArgumentException();
        }

        if(maxSteps <= 0){
            throw new IllegalArgumentException();
        }

        String[] d1 = deck1.split("\\s");
        String[] d2 = deck2.split("\\s");

        for (String card : d1){
            if (Integer.valueOf(card) >= deckType.mNumberOfCards){
                throw new IllegalArgumentException();
            }
            mQueue1.add(Integer.valueOf(card));
        }

        for (String card : d2){
            if (Integer.valueOf(card) >= deckType.mNumberOfCards){
                throw new IllegalArgumentException();
            }
            mQueue2.add(Integer.valueOf(card));
        }

        mDeckType = deckType;
        MAX_STEPS = maxSteps;
    }

    /*
     * Один шаг игры.
     */
    public void step() {
        if(!isActive()){
            return;
        }
        mCurrentStep++;

        Integer card1 = mQueue1.remove();
        Integer card2 = mQueue2.remove();
        mBattleQueue.add(card1); // Добавляем карты на "стол"
        mBattleQueue.add(card2);

        if (compareCards(card1, card2) == 0) { // Если карты равны, начинаем спор
            return;
        } else if (compareCards(card1, card2) > 0) { // Спор выиграл первый игрок
            mQueue1.addAll(mBattleQueue);
            mBattleQueue.clear();
        } else { // Спор выиграл 2ой игрок
            mQueue2.addAll(mBattleQueue);
            mBattleQueue.clear();
        }

        if(mQueue1.size() == 0 || mQueue2.size() == 0){ // У одного игрока закончились карты
            mState = GameState.FINISHED;
            return;
        }

        if(mCurrentStep >= MAX_STEPS){ // Макс. количество ходов превышено -> ничья
            mState = GameState.DRAW;
            return;
        }
    }

    public boolean isActive() {
        return mState == GameState.ACTIVE;
    }

    public GameState getState(){
        return mState;
    }

    public int getWinner() {
        if (mQueue1.size() == mQueue2.size()) {
            return 0;
        } else if (mQueue1.size() > mQueue2.size()) {
            return 1;
        } else {
            return 2;
        }
    }

    private int compareCards(Integer card1, Integer card2){
        if(card1 == 0 && card2 == mDeckType.mNumberOfCards - 1){
            return -1;
        } else if(card2 == 0 && card1 == mDeckType.mNumberOfCards - 1){
            return -1;
        } else {
            return card1.compareTo(card2);
        }
    }

    public int getPlayer1CardCount(){
        return mQueue1.size();
    }

    public int getPlayer2CardCount(){
        return mQueue2.size();
    }

    public int getStep(){
        return mCurrentStep;
    }

    private String getBattleQueue(){
        StringBuilder sb = new StringBuilder();
        for (Integer a : mBattleQueue){
            sb.append(a).append(" ");
        }

        return sb.toString();
    }

    /*
     * Создает новую рандомную колоду.
     */
    private List<Integer> getNewShuffledDeck(){
        Random rand = new Random();
        List<Integer> deck = new ArrayList<>(64);

        for (int suit = 0; suit < 4; suit++){
            for(int i = 0; i < mDeckType.mNumberOfCards; i++){
                deck.add(i);
            }
        }

        for(int i = 0; i < deck.size() - 2; i++){
            int pos = rand.nextInt(deck.size() - i) + i;
            Integer t = deck.get(i);
            deck.set(i, deck.get(pos));
            deck.set(pos, t);
        }

        return deck;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb
                .append(mQueue1.size()).append("\n")
                .append(getBattleQueue()).append("\n")
                .append(mQueue2.size()).append("\n")
                .toString();
    }
}
