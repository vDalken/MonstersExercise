class Werewolf extends Monster {
    public Werewolf() {
        name="Werewolf";
    }

    public void attack(Monster monster){
        monster.HEALTH-=5;
    }

}
