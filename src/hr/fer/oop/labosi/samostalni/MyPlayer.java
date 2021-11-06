package hr.fer.oop.labosi.samostalni;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

public class MyPlayer extends Player implements Iterable<Game> {
    private Map<Game, ArrayList<Integer>> games = new TreeMap<>((g1, g2) -> g1.getName().compareTo(g2.getName()));

    public MyPlayer(String name) {
        super(name);

    }

    @Override
    void addGameScore(Game game, int score) {
        if (!games.containsKey(game)) games.put(game,new ArrayList<>());

        games.get(game).add(score);
    }

    @Override
    Iterable<Integer> getScores(Game game) {
        return new Iterable<Integer>() {

            @Override
            public Iterator<Integer> iterator() {
                return games.get(game).iterator();
            }
        };
    }

    @Override
    public Iterator<Game> iterator() {
        return games.keySet().iterator();
    }
}
