package hr.fer.oop.labosi;

abstract class GroupOfGradable implements Gradable{
    Gradable[] gradable;

    public void add(Gradable gradableThing) {
        Gradable[] newGradable = new Gradable[gradable.length + 1];
        for (int i = 0; i < gradable.length; i++) {
            newGradable[i] = gradable[i];
        }
        newGradable[gradable.length + 1] = gradableThing;
        this.gradable = newGradable;
    }

    @Override
    public int getScores() {
        int rez = 0;
        for (Gradable element : gradable) {
            rez += element.getScores();
        }
        return rez;
    }

    @Override
    public int getMaxScore() {
        int rez = 0;
        for (Gradable element : gradable) {
            rez += element.getMaxScore();
        }
        return rez;
    }

    @Override
    public boolean hasPassed() {
        for (Gradable element : gradable) {
            if (element.getScores() / element.getMaxScore() < 0.5) return false;
        }
        return true;
    }
}
