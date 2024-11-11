// Base action class
abstract class Action implements Actionable {
    protected String name;

    public Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}