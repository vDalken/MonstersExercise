abstract class Monster{
    protected int HEALTH=100;
    protected String name;
    abstract public void attack(Monster monster);

    public String getName() {
        return name;
    }
}
