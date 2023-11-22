class GameManager {
    private final int DEFAULT_NUMBER_OF_MONSTERS = 5;
    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");

    public void startNewGame() {
        System.out.println("\nThe number of monsters you pick has to be the same as your opponent.\n" +
                "If both of you don't reach a consensus, both will get a default number of 5 monsters each\n");
        player1.pickNumberOfMonsters();
        player2.pickNumberOfMonsters();
        if (!(player1.getNumberOfMonsters() == player2.getNumberOfMonsters())) {
            player1.setNumberOfMonsters(DEFAULT_NUMBER_OF_MONSTERS);
            player2.setNumberOfMonsters(DEFAULT_NUMBER_OF_MONSTERS);
        }
        player1.initializeMonsters();
        player2.initializeMonsters();
        player1.showArrayListOfMonsters();
        player2.showArrayListOfMonsters();
        do {
            player1.randomizedAttack(player2);
            if (player2.getMonsters().isEmpty()) {
                break;
            }
            player2.randomizedAttack(player1);
            if (player1.getMonsters().isEmpty()) {
                break;
            }
        } while (!player1.getMonsters().isEmpty() || !player2.getMonsters().isEmpty());
        if (player1.getMonsters().isEmpty()) {
            System.out.println("\nPlayer 1 won");
        } else {
            System.out.println("\nPlayer 2 won");
        }
    }

}
