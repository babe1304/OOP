package hr.fer.oop.labosi;

public class CartoonChecker {

    public static void processCharacter(String name) {
        boolean isInList = false;
        for (String names : Peppa.getAllCharacters()) {
            if (name.equals(names)) {
                isInList = true;
                break;
            }
        }
        if (isInList) System.out.printf("%s JE lik u crtanom filmu Peppa Pig", name);
        else {
            throw new InvalidPeppaPigCharacterException(String.format("%s NIJE lik u crtanom filmu Peppa Pig", name));
        }
    }
}
