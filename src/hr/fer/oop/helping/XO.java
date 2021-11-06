package hr.fer.oop.helping;

public class XO extends XOInterface {
    private int moves = 0;

    @Override
    public void start() {
        if (moves == 0 && getPlayer() == 0) {
            this.setPlayer(1);
        } else throw new XOException("Game already started");
    }

    @Override
    public boolean play(int field) {
        if (field > 8 || field < 0) throw new XOException("Invalid field");

        int[] content = this.getFields();

        if (content[field] != 0) throw new XOException("Field already taken");
        if (getPlayer() == 0 ) throw new XOException("Game not started");
        
        int currentPlayer = this.getPlayer();
        if (setField(field, currentPlayer)) {
            stop();
            return true;
        }
        if (moves < 8) {
            setField(field, currentPlayer);

            if (currentPlayer == 1) {
                setPlayer(2);
            } else setPlayer(1);

            moves++;

        } else {
            stop();
            return false;
        }
        return false;
    }

    @Override
    public void stop() {
        if (getPlayer() == 0) {
            throw new XOException("Game already stopped");
        } else {
            setPlayer(0);
            resetFields();
            moves = 0;
        }
    }
}
