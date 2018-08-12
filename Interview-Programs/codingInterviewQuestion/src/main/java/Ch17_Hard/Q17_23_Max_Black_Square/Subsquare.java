package Ch17_Hard.Q17_23_Max_Black_Square;

class Subsquare {
    private final int row;
    private final int column;
    private final int size;

    public Subsquare(int r, int c, int sz) {
        row = r;
        column = c;
        size = sz;
    }

    public void print() {
        System.out.println("(" + row + ", " + column + ", " + size + ")");
    }
}