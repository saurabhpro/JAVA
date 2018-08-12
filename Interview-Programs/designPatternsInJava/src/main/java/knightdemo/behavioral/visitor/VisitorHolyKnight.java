package knightdemo.behavioral.visitor;

import knightdemo.model.HolyKnight;

/**
 * @author saurabh
 * <p>
 * Implementation of visitor knight
 */
public class VisitorHolyKnight extends HolyKnight implements VisitorKnight {

    public Double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
