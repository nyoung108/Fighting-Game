package battlegame;

import java.util.Random;
import java.util.Scanner;

public class BattleGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String[] moves = new String[3];
        int[] champStats = new int[3];
        int[] enemyStats = new int[3];
        boolean valid = false;

        System.out.println("Your stats: ");
        fighter(champStats);
        enemy(enemyStats);
        availablemoves(moves);
        double playerHealth = 300;
        double enemyHealth = 300;
        while (valid == false) {

            while ((playerHealth > 0) && (enemyHealth > 0)) {

                int playerMultiplier = rand.nextInt((15 - 10) + 1) + 10;
                int enemyMultiplier = rand.nextInt((15 - 10) + 1) + 10;
                int playerSpeed = (champStats[2] * playerMultiplier);
                int enemySpeed = (enemyStats[2] * enemyMultiplier);
                try {
                    if (playerSpeed >= enemySpeed) {
                        System.out.println();
                        System.out.println("Select move 0 or 1 or 2");
                        int selectedMove = input.nextInt();
                        if ((selectedMove > 2) || (selectedMove < 0)) {
                            while ((selectedMove > 2) || (selectedMove < 0)) {
                                System.out.println("This is not a valid move!");
                                System.out.println("Select move 0 or 1 or 2");
                                selectedMove = input.nextInt();
                            }
                        }
                        if (selectedMove == 0) {
                            int miss = rand.nextInt((5 - 1) + 1) - 1;
                            int crit = rand.nextInt((20 - 1) + 1) - 1;
                            if (miss == 1) {
                                System.out.println("Attack missed");
                            }
                            if (miss != 1) {
                                if (crit == 1) {
                                    int damage = (champStats[0] * playerMultiplier * 20 * 2 / enemyStats[1] / 10);
                                    enemyHealth = enemyHealth - damage;
                                    System.out.println("Critical hit! You dealt " + damage + " damage");
                                }
                                if (crit != 1) {
                                    int damage = (champStats[0] * playerMultiplier * 20 / enemyStats[1] / 10);
                                    enemyHealth = enemyHealth - damage;
                                    System.out.println("You dealt " + damage + " damage");
                                }
                            }

                        }

                        if (selectedMove == 1) {
                            int miss = rand.nextInt((5 - 1) + 1) - 1;
                            int crit = rand.nextInt((10 - 1) + 1) - 1;
                            if (crit == 1) {
                                int damage = (champStats[0] * playerMultiplier * 15 * 2 / enemyStats[1] / 10);
                                enemyHealth = enemyHealth - damage;
                                System.out.println("Critical hit! You dealt " + damage + " damage");
                            }
                            if (crit != 1) {
                                if (miss != 1) {
                                    int damage = (champStats[0] * playerMultiplier * 15 / enemyStats[1] / 10);
                                    enemyHealth = enemyHealth - damage;
                                    System.out.println("You dealt " + damage + " damage");
                                }
                            }
                            if (miss == 1) {
                                System.out.println("Attack missed");
                            }

                        }
                        if (selectedMove == 2) {
                            int miss = rand.nextInt((3 - 1) + 1) - 1;
                            int crit = rand.nextInt((20 - 1) + 1) - 1;
                            if (miss == 1) {
                                System.out.println("Attack missed");
                            }
                            if (miss != 1) {
                                if (crit == 1) {
                                    int damage = (champStats[0] * playerMultiplier * 25 * 2 / enemyStats[1] / 10);
                                    enemyHealth = enemyHealth - damage;
                                    System.out.println("Critical hit! You dealt " + damage + " damage");
                                }
                                if (crit != 1) {
                                    int damage = (champStats[0] * playerMultiplier * 25 / enemyStats[1] / 10);
                                    enemyHealth = enemyHealth - damage;
                                    System.out.println("You dealt " + damage + " damage");
                                }
                            }

                        }
                        if (enemyHealth > 0) {
                            int emiss = rand.nextInt((5 - 1) + 1) - 1;
                            int ecrit = rand.nextInt((20 - 1) + 1) - 1;
                            if (emiss == 1) {
                                System.out.println("Enemy attack missed");
                            }
                            if (emiss != 1) {
                                if (ecrit == 1) {
                                    int enemyDamage = (enemyStats[0] * enemyMultiplier * 20 * 2 / champStats[1] / 10);
                                    playerHealth = playerHealth - enemyDamage;
                                    System.out.println("Critical hit! Enemy dealt " + enemyDamage + " damage");
                                }
                                if (ecrit != 1) {
                                    int enemyDamage = (enemyStats[0] * enemyMultiplier * 20 / champStats[1] / 10);
                                    playerHealth = playerHealth - enemyDamage;
                                    System.out.println("Enemy dealt " + enemyDamage + " damage");
                                }
                            }

                        }
                    }

                    if (enemySpeed > playerSpeed) {
                        int emiss = rand.nextInt((5 - 1) + 1) - 1;
                        int ecrit = rand.nextInt((20 - 1) + 1) - 1;
                        System.out.println();
                        System.out.println("Select move 0 or 1 or 2");
                        int selectedMove = input.nextInt();
                        if ((selectedMove > 2) || (selectedMove < 0)) {
                            while ((selectedMove > 2) || (selectedMove < 0)) {
                                System.out.println("This is not a valid move!");
                                System.out.println("Select move 0 or 1 or 2");
                                selectedMove = input.nextInt();
                            }
                        }
                        if (emiss == 1) {
                            System.out.println("Enemy attack missed");
                        }
                        if (emiss != 1) {
                            if (ecrit == 1) {
                                int enemyDamage = (enemyStats[0] * enemyMultiplier * 20 * 2 / champStats[1] / 10);
                                playerHealth = playerHealth - enemyDamage;
                                System.out.println("Critical hit! Enemy dealt " + enemyDamage + " damage");
                            }
                            if (ecrit != 1) {
                                int enemyDamage = (enemyStats[0] * enemyMultiplier * 20 / champStats[1] / 10);
                                playerHealth = playerHealth - enemyDamage;
                                System.out.println("Enemy dealt " + enemyDamage + " damage");
                            }
                        }

                        if (playerHealth > 0) {
                            int miss = rand.nextInt((5 - 1) + 1) - 1;
                            int crit = rand.nextInt((20 - 1) + 1) - 1;
                            if (selectedMove == 0) {

                                if (miss == 1) {
                                    System.out.println("Attack missed");
                                }
                                if (miss != 1) {
                                    if (crit == 1) {
                                        int damage = (champStats[0] * playerMultiplier * 20 * 2 / enemyStats[1] / 10);
                                        enemyHealth = enemyHealth - damage;
                                        System.out.println("Critical hit! You dealt " + damage + " damage");
                                    }
                                    if (crit != 1) {
                                        int damage = (champStats[0] * playerMultiplier * 20 / enemyStats[1] / 10);
                                        enemyHealth = enemyHealth - damage;
                                        System.out.println("You dealt " + damage + " damage");
                                    }
                                }

                            }

                            if (selectedMove == 1) {

                                if (crit == 1) {
                                    int damage = (champStats[0] * playerMultiplier * 15 * 2 / enemyStats[1] / 10);
                                    enemyHealth = enemyHealth - damage;
                                    System.out.println("Critical hit! You dealt " + damage + " damage");
                                }
                                if (crit != 1) {
                                    if (miss != 1) {
                                        int damage = (champStats[0] * playerMultiplier * 15 / enemyStats[1] / 10);
                                        enemyHealth = enemyHealth - damage;
                                        System.out.println("You dealt " + damage + " damage");
                                    }
                                }
                                if (miss == 1) {
                                    System.out.println("Attack missed");
                                }

                            }
                            if (selectedMove == 2) {

                                if (miss == 1) {
                                    System.out.println("Attack missed");
                                }
                                if (miss != 1) {
                                    if (crit == 1) {
                                        int damage = (champStats[0] * playerMultiplier * 25 * 2 / enemyStats[1] / 10);
                                        enemyHealth = enemyHealth - damage;
                                        System.out.println("Critical hit! You dealt " + damage + " damage");
                                    }
                                    if (crit != 1) {
                                        int damage = (champStats[0] * playerMultiplier * 25 / enemyStats[1] / 10);
                                        enemyHealth = enemyHealth - damage;
                                        System.out.println("You dealt " + damage + " damage");
                                    }
                                }

                            }
                        }
                    }
                    System.out.println("Player Health: " + playerHealth);
                    System.out.println("Enemy Health: " + enemyHealth);

                    if ((playerHealth > 0) && (enemyHealth <= 0)) {
                        System.out.println("You were victorious");
                    }
                    if ((playerHealth <= 0) && (enemyHealth > 0)) {
                        System.out.println("You were defeated");
                    }
                    valid = true;

                } catch (Exception e) {
                    System.out.println("This is not a valid attack");
                    input.next();
                }
            }
        }
    }

    public static int[] fighter(int[] champStats) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int speed = rand.nextInt((30 - 15) + 1) + 15;
        int strength = rand.nextInt((30 - 15) + 1) + 15;
        int defense = rand.nextInt((30 - 15) + 1) + 15;
        champStats[0] = strength;
        champStats[1] = defense;
        champStats[2] = speed;
        System.out.println("Your Stats:");
        System.out.println("Strength: " + strength);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);
        System.out.println();

        return champStats;
    }

    public static int[] enemy(int[] enemyStats) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int speed = rand.nextInt((30 - 15) + 1) + 15;
        int strength = rand.nextInt((30 - 15) + 1) + 15;
        int defense = rand.nextInt((30 - 15) + 1) + 15;
        enemyStats[0] = strength;
        enemyStats[1] = defense;
        enemyStats[2] = speed;

        System.out.println("Enemy Stats: ");
        System.out.println("Strength: " + strength);
        System.out.println("Defense: " + defense);
        System.out.println("Speed: " + speed);

        return enemyStats;
    }

    public static String[] availablemoves(String[] moves) {
        int moveNumber = 0;
        moves[0] = "Base 20 standard attack";
        moves[1] = "Base 15 increased critical attack";
        moves[2] = "Base 25 decreased accuracy attack attack";
        System.out.println();
        for (int i = 0; i < moves.length; i++) {
            System.out.println("Move " + moveNumber + ": " + moves[i]);
            moveNumber++;
        }

        return moves;

    }
}
