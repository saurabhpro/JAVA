/**
 * Created by Saurabh on 11/8/2015.
 */
enum FaceDirections{
    NORTH, EAST, WEST, SOUTH;
}
enum MoveDirections {
    LEFT, RIGHT
}

class Position {
    int x, y;

    Position() {
        x = y = 0;
    }

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position updateOnLeft() {
        this.x--;
        return this;
    }
}

class Location {
    Position position;
    FaceDirections directions;

    Location(Position p, FaceDirections d) {
        position = p;
        directions = d;
    }
}

class LMovement {
    Location location;

    void move(FaceDirections directions) {
        switch (directions) {
            case EAST:
                new Location(new Position().updateOnLeft(), FaceDirections.NORTH);
            case WEST:
                new Location(new Position().updateOnLeft(), FaceDirections.SOUTH);
            case NORTH:
                new Location(new Position().updateOnLeft(), FaceDirections.WEST);
            case SOUTH:
                new Location(new Position().updateOnLeft(), FaceDirections.EAST);
        }
    }
}

public class MarsSol1 {

}
