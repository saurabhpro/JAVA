package ooad;

/**
 * Since Engine is-part-of Car, the relationship between them is Composition.
 * If we delete parent - child is gone too
 * by making it final, your provide guarantee that, when Owner will be created, this part object will exist.
 * This is actually a Java idiom to represent a strong form of association i.e. composition between two objects.
 */
public class CarWithCompositeEngine {
    //final will make sure engine is initialized
    private final Engine engine;

    public CarWithCompositeEngine() {
        engine = new Engine();
    }
}

//PART-OF / BELONGS TO
class Engine {
    private String type;
}