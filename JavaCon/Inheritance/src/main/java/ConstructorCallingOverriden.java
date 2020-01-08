class Super {
    // Broken - constructor invokes an overridable method
    public Super() {
        overrideMe();
    }
    
    public void overrideMe() {
        //nothing here
    }
}

final class Sub extends Super {
    // Blank final, set by constructor
    private final String instant;
    
    Sub() {
        instant = "Instant.now()";
    }
    
    // Overriding method invoked by superclass constructor
    @Override public void overrideMe() {
        System.out.println(instant);
    }
}

public final class ConstructorCallingOverriden {
     public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
