package hr.fer.oop.helping;

abstract class XOInterface {
    private int currentPlayer;
    private int[] fields;

    public XOInterface() {
        this.currentPlayer = 0;
        this.fields = new int[]{ 0,0,0,0,0,0,0,0,0 };
    }

    public int getPlayer() {
        return currentPlayer;
    }

    public void setPlayer(int newPlayer) {
        currentPlayer = newPlayer;
    }

    public int[] getFields() {
        return fields;
    }

    protected boolean setField(int field, int value) {
        fields[field] = value;

        int x = field % 3;
        int y = field / 3;
        boolean diag1 = x == y;
        boolean diag2 = x + y == 2;

        int[] count = new int[] {0,0,0,0};
        boolean win = false;

        for(int i = 0; i < 3; i++) {
            if(fields[i*3+x] == value)
                count[0] += 1;
            if(fields[y*3+i] == value)
                count[1] += 1;
            if(diag1)
                if(fields[4*i] == value)
            count[2] += 1;
            if(diag2)
                if(fields[2+2*i] == value)
            count[3] += 1;
        }

        for(int i = 0; i < 4; i++)
            if(count[i] == 3)
                win = true;

        return win;
    }

    public void resetFields() {
        this.fields = new int[]{ 0,0,0,0,0,0,0,0,0 };
    }

    public abstract void start();
    public abstract boolean play(int field);
    public abstract void stop();

}
