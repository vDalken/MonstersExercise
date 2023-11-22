import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Player {
    private String name;
    private int numberOfMonsters;
    private ArrayList<Monster> monsters;

    public Player(String name) {
        this.name = name;
    }

    public void pickNumberOfMonsters() {
        String numberOfMonstersPickedByUser;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.print(this.name + " please pick a number: ");
            numberOfMonstersPickedByUser = scan.nextLine();
            if (isNumberPickedByUserValid(numberOfMonstersPickedByUser)) {
                numberOfMonsters = Integer.parseInt(numberOfMonstersPickedByUser.trim());
            } else {
                System.out.println("Write a number please");
            }
        } while (!isNumberPickedByUserValid(numberOfMonstersPickedByUser));
    }

    public void initializeMonsters() {
        monsters = new ArrayList<>();
        Random randomize = new Random();
        int numberOfMonstersToCreate = numberOfMonsters;
        while (numberOfMonstersToCreate > 0) {
            int randomizedNumber = randomize.nextInt(101);
            randomizeMonster(randomizedNumber);
            numberOfMonstersToCreate--;
        }
    }

    private void randomizeMonster(int randomizedNumber) {
        if (randomizedNumber <= 33) {
            monsters.add(new Mummy());
        } else if (randomizedNumber <= 66) {
            monsters.add(new Vampire());
        } else {
            monsters.add(new Werewolf());
        }
    }

    public void randomizedAttack(Player defendingPlayer) {
        int indexOfAttackingPlayer = randomizeIndexOfMonster(this.numberOfMonsters);
        int indexOfDefendingPlayer = randomizeIndexOfMonster(defendingPlayer.numberOfMonsters);
        String nameOfAttackedMonster = this.monsters.get(indexOfAttackingPlayer).name;
        String nameOfDefendingMonster = defendingPlayer.monsters.get(indexOfDefendingPlayer).getName();

        this.monsters.get(indexOfAttackingPlayer).attack(defendingPlayer.monsters.get(indexOfDefendingPlayer));
        int healthOfDefendingMonster = defendingPlayer.monsters.get(indexOfDefendingPlayer).HEALTH;

        if (defendingPlayer.monsters.get(indexOfDefendingPlayer).HEALTH <= 0) {
            defendingPlayer.monsters.remove(defendingPlayer.monsters.get(indexOfDefendingPlayer));
            defendingPlayer.numberOfMonsters--;
        }
        logOfEachRound(nameOfAttackedMonster, nameOfDefendingMonster, healthOfDefendingMonster, defendingPlayer);
    }

    private void logOfEachRound(String nameOfAttackedMonster, String nameOfDefendingMonster, int healthOfDefendingMonster, Player defendingPlayer) {
        if (healthOfDefendingMonster > 0) {
            System.out.println("\nThe " + nameOfAttackedMonster + " of " + this.name
                    + " attacked the " + nameOfDefendingMonster + " of " + defendingPlayer.name + " and the " +
                    nameOfDefendingMonster + " has now " + healthOfDefendingMonster + " health");
        } else {
            System.out.println("\nThe " + nameOfAttackedMonster + " of " + this.name + " attacked the "
                    + nameOfDefendingMonster + " of " + defendingPlayer.name + " and killed it");
        }
    }

    public void showArrayListOfMonsters() {
        System.out.println("\nHere is the monsters list of " + this.name);
        for (Monster monster : monsters) {
            System.out.println(monster.name);
        }
    }

    private int randomizeIndexOfMonster(int numberOfMonstersOfPlayer) {
        Random randomize = new Random();
        return randomize.nextInt(numberOfMonstersOfPlayer);
    }

    private boolean isNumberPickedByUserValid(String numberOfMonstersPickedByUser) {
        if (numberOfMonstersPickedByUser.trim().matches("\\d+$")) {
            return true;
        }
        return false;
    }

    public int getNumberOfMonsters() {
        return numberOfMonsters;
    }

    public void setNumberOfMonsters(int numberOfMonsters) {
        this.numberOfMonsters = numberOfMonsters;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
}
