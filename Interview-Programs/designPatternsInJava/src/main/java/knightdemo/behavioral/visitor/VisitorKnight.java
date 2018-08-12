package knightdemo.behavioral.visitor;

import knightdemo.model.Knight;

/**
 * @author saurabh
 * <p>
 * Knight that can be visited
 */
public interface VisitorKnight extends Knight {
    Double accept(Visitor knightVisitor);
}
