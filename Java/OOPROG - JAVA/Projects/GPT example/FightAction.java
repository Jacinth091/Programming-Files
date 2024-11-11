
class FightAction extends Action {
    public FightAction() {
        super("Fight");
    }

    @Override
    public void perform() {
        System.out.println("Fighting the enemy...");
    }
}