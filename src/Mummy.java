class Mummy extends Monster {
    private int numberOfAttacks = 0;

    public Mummy() {
        name="Mummy";
    }

    public void attack(Monster monster) {
        if (numberOfAttacks == 3) {
            this.HEALTH -= 5;
            numberOfAttacks = 0;
        } else {
            monster.HEALTH -= 5;
            numberOfAttacks++;
        }
    }
}
