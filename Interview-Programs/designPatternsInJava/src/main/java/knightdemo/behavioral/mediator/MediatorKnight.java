package knightdemo.behavioral.mediator;

import knightdemo.model.Knight;

/**
 * @author saurabh
 * <p>
 * Knight with new extra abilities send a quest to fellow knights and receive a quest.
 */
public interface MediatorKnight extends Knight {

    void receiveQuest(String quest);

    void sendQuest();
}
