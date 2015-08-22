/**
 * Created by Saurabh on 8/14/2015.
 */

interface X {
    void show();
}

interface Y {
    void show();
}

class XX implements X, Y {

    @Override
    //// There can only be one implementation of this method.
    //C# has explicit Interface Implementation !! Java doesn't
    public void show() {
        System.out.println("Hello X");
    }
}

public class DiamondProblem extends XX implements Y {

    public static void main(String[] args) {
        DiamondProblem d = new DiamondProblem();
        d.show();
    }
}
