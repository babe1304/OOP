package hr.fer.oop.labosi.samostalni;

public class Factory extends Game {

    protected Factory(String name, int rating) {
        super(name);
        this.setRating(rating);
    }


    public static Game createGame(String name, int rating) {
        return new Factory(name, rating);
    }

}
