package hr.fer.oop.labosi;

public class LaboratoryExcercise extends GroupOfGradable {
    private float passingPercentage;

    LaboratoryExcercise(float passingPercentage) {
        this.passingPercentage = passingPercentage;
    }

    @Override
    public boolean hasPassed() {
        for (Gradable element : gradable) {
            if (element.getScores() / element.getMaxScore() < 0.5) return false;
        }
        if (this.getScores() / this.getMaxScore() < passingPercentage) return false;
        else return true;
    }
}
