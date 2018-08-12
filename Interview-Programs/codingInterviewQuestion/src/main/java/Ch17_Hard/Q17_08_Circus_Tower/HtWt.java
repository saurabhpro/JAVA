package Ch17_Hard.Q17_08_Circus_Tower;

class HtWt implements Comparable<HtWt> {
    private final int height;
    private final int weight;

    public HtWt(int h, int w) {
        height = h;
        weight = w;
    }

    public int compareTo(HtWt second) {
        if (this.height != second.height) {
            return Integer.compare(this.height, second.height);
        } else {
            return Integer.compare(this.weight, second.weight);
        }
    }

    public String toString() {
        return "(" + height + ", " + weight + ")";
    }

    /* Returns true if "this" should be lined up before "other". Note
     * that it's possible that this.isBefore(other) and
     * other.isBefore(this) are both false. This is different from the
     * compareTo method, where if a < b then b > a. */
    public boolean isBefore(HtWt other) {
        if (height < other.height && weight < other.weight) {
            return true;
        } else {
            return false;
        }
    }
}
