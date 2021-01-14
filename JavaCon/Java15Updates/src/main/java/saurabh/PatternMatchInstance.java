package saurabh;

// preview
public class PatternMatchInstance {
    public static void main(String[] args) {
        String obj = "";

        // previously < 14
        // if (obj instanceof String) {}

        if (obj instanceof String str) {
            // can use str here
            System.out.println("".equals(str));
        } else {
            // can't use str here
            System.out.println("Can't use str here");
        }
    }
}
