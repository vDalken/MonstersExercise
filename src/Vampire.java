import java.util.Random;

class Vampire extends Monster {

    public Vampire() {
        name="Vampire";
    }

    public void attack(Monster monster) {
        monster.HEALTH -= 5;
        tryToBiteEnemy();
    }

    private void tryToBiteEnemy() {
        Random randomize = new Random();
        int randomNumber = randomize.nextInt(101);
        if (randomNumber <= 20) {
            this.HEALTH += 5;
        }
    }

}
