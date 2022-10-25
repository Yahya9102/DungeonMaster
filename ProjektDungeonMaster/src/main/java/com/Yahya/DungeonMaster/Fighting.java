package com.Yahya.DungeonMaster;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.Yahya.DungeonMaster.Col.ConsoleColors.*;
import static com.Yahya.DungeonMaster.Player.*;

public class  Fighting implements ICombat  {
    int playerReply;
    public void optionsMenu() {
        Player player = new Player();
        Monster monster = new Monster();
        Scanner scanner = new Scanner(System.in);
        Boolean playing = true;
        Boolean pickingOption;

        do {

            System.out.println("Press \n" +
                    " 1 to show your stats \n" +
                    " 2 to fight Murloc \n" +
                    " 3 to fight Orc\n" +
                    " 4 to fight the last boss\n" +
                    " 5 to flee and reset yours and mob healths \n" +
                    " 6 to show mob status \n" +
                    " 7 to fight " + Monster.getJabbaName() + " until death \n" +
                    " 8 to revive and reset your health \n" +
                    " 9 to quit the game");

            do {
                try {
                    pickingOption = false;
                    playerReply = scanner.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Please type in a number between 1-9");
                    scanner.next();
                    pickingOption = true;
                }

            }while (pickingOption);





            switch (playerReply) {
                case 1 -> {
                    player.playerStats();
                }
                case 2 -> {
                    if (Player.getHealth() <= 0){
                        System.out.println("You´re dead and can not attack, press 8 to flee and reset your health");
                        break;
                    }
                    System.out.println("You have chosen to fight: " + Monster.getLowLevelMurloc());
                    fightingMurloc();
                }
                case 3 -> {
                    if (Player.getHealth() <= 0){
                        System.out.println("You´re dead and can not attack, press 8 to flee and reset your health");
                        break;
                    }
                    System.out.println("You have chosen to fight: " + Monster.getMidLevelOrc());
                    fightingOrc();
                }
                case 4 -> {
                    if (Player.getHealth() <= 0){
                        System.out.println("You´re dead and can not attack, press 8 to flee and reset your health");
                        break;
                    }
                    System.out.println("You´re fighting: " + Monster.getJabbaName());
                    fightingLastBoss();
                }
                case 5 -> {
                    System.out.println(BLUE+"You have fled from the combat and reset your health and monster healths"+RESET);
                    Monster.murlocHp = 100;
                    Monster.orcHp = 150;
                    Monster.jabbaHealth = 175;
                    if (level >= 1)
                    for (int i = 0; i < level; i++) {
                        Player.setHealth(Player.getMaxHealth() +10);
                    }
                    else if (level == 0){
                        Player.setHealth(maxHealth);
                    }
                }
                case 6 -> monster.monsterStatus();

                case 7 -> {
                    if (Player.getHealth() <= 0){
                        System.out.println("You´re dead and can not attack, press 8 to flee and reset your health");
                        break;
                    }
                    System.out.println("Fighting " + Monster.getJabbaName() + " until death");
                     fightingLastBossUntilDeath();
                     Monster.jabbaHealth = 175;
                }
                case 8 -> {
                    if (getHealth() <= 0) {
                        System.out.println("You have resurrected from the dead and reset your health");
                        if (level >= 1) {
                            for (int i = 0; i < level; i++) {
                                Player.setHealth(Player.getMaxHealth() + 10);
                            }
                        }else {
                            Player.setHealth(Player.getMaxHealth());
                        }
                    }
                    else if (getHealth() >= 0){
                        System.out.println("You can not use this option when you´re alive");
                    }
                }
                case 9 -> playing = false;
                default -> player.playerStats();
            }
        }
        while (playing);
    }




    public void fightingMurloc() {
        Player player = new Player();
        Boolean isPlaying = true;

        do {
          
            if (Player.getHealth() <=0){
                break;
            }
              murlocAttack();
            if (Player.getHealth() >= 0) {
                isPlaying = false;
            }
            if (Player.getHealth() <=0){
                System.out.println("You´re dead and can not attack, press 8 to flee and reset your health");
                break;
            }
            if (Monster.murlocHp >= 0) {
                isPlaying = false;
            }player.playerAttackMurloc();
        }
        while (isPlaying);
    }
    public void fightingOrc() {
        Player player = new Player();

        Boolean isPlaying = true;
        do {
            if (Player.getHealth() <= 0){
                break;
            }
            orcAttack();
            if (Player.getHealth() >= 0) {
                isPlaying = false;
            }
            if (Player.getHealth() <= 0){
                System.out.println("You´re dead and can not attack, press 8 to flee and reset your health");
                break;
            }
            if (Monster.orcHp >= 0) {
                isPlaying = false;
            }
            player.playerAttackOrc();
        }
        while (isPlaying);
    }
    public void fightingLastBoss() {
        Player player = new Player();

        Boolean isPlaying = true;
        do {
            if (Player.getHealth() <= 0){
                break;
            }
            jabbaAttack();
            if (Player.getHealth() >= 0) {
                isPlaying = false;
            }
            if (Player.getHealth() <=0){
                System.out.println("You´re dead and can not attack, press 8 to flee and reset your health");
                optionsMenu();
                break;
            }
            if (Monster.jabbaHealth >= 0) {
                isPlaying = false;
            }
            player.playerAttackJabba();
        }
        while (isPlaying);

    }

    public int fightingLastBossUntilDeath() {
        Player player = new Player();

            do {
                if (Monster.jabbaHealth <= 0){
                    break;
                }
                    jabbaAttackUntilDeath();
                    if (Player.getHealth() <= 0){
                        break;
                    }
                    player.playerAttackJabba();
            } while (Player.getHealth() > 0 || Monster.jabbaHealth > 0);
            return health; // returning this so i can do a test in EnhetsTester
    }
}

