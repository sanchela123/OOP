package com.company;


/* Два варианта развития игры, 1 - отсутствуют входные данные, 2 - на вход подаются три аргумента:
* строка с картами первого игрока, строка с картами второго игрока, макс число ходов.*/
public class Main {

    public static void main(String[] args) {
        {
            Game game;
            if (args.length != 3) {
                game = new Game(Game.DeckType.DECK_36, 1000);
            } else {
                game = new Game(Game.DeckType.DECK_36, Integer.valueOf(args[2]), args[0], args[1]);
            }

            while (game.isActive()) {
                game.step();
                System.out.println(String.format("Step #%d", game.getStep()));
                System.out.println(game);
                System.out.println();
            }

            if (game.getState() == Game.GameState.DRAW) {
                System.out.println("Botva");
            } else {
                System.out.println(String.format("The winner is player #%d", game.getWinner()));
            }
        }
    }
}