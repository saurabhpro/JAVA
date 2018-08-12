package knightdemo.behavioral.command;

import knightdemo.model.Knight;

/**
 * @author saurabh
 * <p>
 * Implementation of command , allowing knight to teleport to destination
 */
public class TeleportKnightCommand implements Command {

    private Knight knight;
    private String destination;

    public TeleportKnightCommand(Knight knight, String destination) {
        this.knight = knight;
        this.destination = destination;
    }

    public Boolean execute() {
        System.out.println("Teleporting knight '" + knight.getName() + "' to " + this.destination);
        return true;
    }
}
