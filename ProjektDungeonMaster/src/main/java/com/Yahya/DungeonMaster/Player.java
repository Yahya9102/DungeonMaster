package com.Yahya.DungeonMaster;

import java.util.Random;
import java.util.Scanner;

import static com.Yahya.DungeonMaster.Col.ConsoleColors.*;
import static com.Yahya.DungeonMaster.Monster.*;

public class Player implements ICombat{

    private static String playerName;

    public static String getPlayerName() {
        return playerName;
    }

    protected static int health = 100;

    protected static int maxHealth = 100;
    private static final int baseDamage = 2;
    private static int strength = 10;
    private static int intelligence = 11;
    private static int agility = 9;
    private static int experience = 0;
    public static int level = 0;


    public static int getMaxHealth() {
        return maxHealth;
    }

    public static int getHealth() {
        return health;
    }

    public static int getStrength() {
        return strength;
    }

    public static int getExperience() {
        return experience;
    }


    public static int getIntelligence() {
        return intelligence;
    }

    public static int getAgility() {
        return agility;
    }

    public static int getBaseDamage() {
        return baseDamage;
    }


    public static void setAgility(int agility) {
        Player.agility = agility;
    }

    public static void setIntelligence(int intelligence) {
        Player.intelligence = intelligence;
    }

    public static void setExperience(int experience) {
        Player.experience = experience;
    }

    public static void setStrength(int strength) {
        Player.strength = strength;
    }

    public static void setHealth(int health) {
        Player.health = health;
    }

    public void playerStats() {

        System.out.println("Here are your stats "  + PURPLE_BOLD_BRIGHT +playerName + RESET);
        System.out.println("Your health is: " +BLUE_BRIGHT + health + RESET);
        System.out.println("Your base damage is: " +RED_BRIGHT + baseDamage + RESET);
        System.out.println("Your strength is: " + PURPLE + strength + RESET);
        System.out.println("Your intelligence is: " + YELLOW_BOLD +intelligence+ RESET);
        System.out.println("Your agility is: " + GREEN_BOLD_BRIGHT + agility + RESET);
        System.out.println("Your current experience is: " + YELLOW_BOLD_BRIGHT +experience + RESET);
        System.out.println("Your current level is: " + CYAN + level +RESET);
    }


    public void setPlayerName() {
        System.out.println("Welcome hero please type in your name!");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.next(); // this might have changed
        System.out.println("Welcome all mighty " + playerName);

    }

    public int playerAttackMurloc() {
            Random attack = new Random();
            System.out.println(getPlayerName() + " is attacking ");
            attack.nextInt();
            int dmg = attack.nextInt(1, 15);

            if (dmg == getIntelligence()) {
                System.out.println(getPlayerName() + " did a " + RED + "critical " + RESET + " damage of " + RED + (dmg + getIntelligence()) + RESET);
                murlocHp = murlocHp - (dmg + getIntelligence());
                System.out.println(getLowLevelMurloc() + " has " + BLUE + murlocHp + " health left " + RESET);
            } else {
                System.out.println(getPlayerName() + " did " + RED+(dmg + baseDamage + getStrength() / 2) +RESET+ " damage to " + getLowLevelMurloc());
                murlocHp = murlocHp - (dmg + getBaseDamage() + getStrength() / 2);
                System.out.println(getLowLevelMurloc() + " has " + BLUE + murlocHp + " health left " + RESET);
            }
            if (murlocHp <= 0) {
                setExperience((experience+5));

                System.out.println(RED + getLowLevelMurloc() + " has died" + RESET);
                if (getExperience() >= 20) {
                    levelUp();
                }
                murlocHp = 100;
            }return dmg; // returning this only to be able to test
        }

    public void playerAttackOrc() {

            Random attack = new Random();
            System.out.println(getPlayerName() + " is attacking ");
            attack.nextInt();
            int dmg = attack.nextInt(1, 20);

        if (dmg == getIntelligence()) {
                System.out.println(getPlayerName() + " did a " + RED + "critical " + RESET + " damage of " + RED + (dmg + getIntelligence()) + RESET);
                orcHp = orcHp - (dmg + getIntelligence());

                System.out.println(getMidLevelOrc() + " has " +BLUE + orcHp + " health left " + RESET);
            } else {
                System.out.println(getPlayerName() + " did " + (dmg + getBaseDamage() + getStrength() / 2) + " damage to " + getMidLevelOrc());
                orcHp = orcHp - (dmg + getBaseDamage() + getStrength() / 2);
                System.out.println(getMidLevelOrc() + " has " + BLUE + orcHp + " health left " + RESET);
            }

            if (orcHp <= 0) {
                setExperience((experience+10));
                System.out.println(RED + getMidLevelOrc() + " has died" + RESET);
                if (getExperience() >= 20) {
                    levelUp();
                }
                orcHp = 150;
            }
        }

    public void playerAttackJabba() {
            Random attack = new Random();
            System.out.println(getPlayerName() + " is attacking ");
            attack.nextInt();
            int dmg = attack.nextInt(15, 30);

            if (dmg == getIntelligence()) {
                System.out.println(getPlayerName() + " did a " + RED + "critical " + RESET + " damage of " + RED + (dmg + getIntelligence()) + RESET);
                jabbaHealth = jabbaHealth - (dmg + getIntelligence());

                System.out.println(getJabbaName() + " has " +BLUE +jabbaHealth + " health left "+RESET);
            } else {
                System.out.println(getPlayerName() + " did " + RED_BOLD +(dmg + getBaseDamage() + getStrength() / 2) + RESET+ " damage to " + getJabbaName());
                jabbaHealth = jabbaHealth - (dmg + getBaseDamage() + getStrength() / 2);
                System.out.println(getJabbaName() + " has " + BLUE + jabbaHealth + " health left " + RESET);
            }

            if (jabbaHealth <= 0) {
                setExperience((experience+20));
                System.out.println(RED + getJabbaName() + " has died" + RESET);

                if (getExperience() >= 20) {
                    levelUp();
                }
                jabbaHealth = 175;
            }
        }
        public int levelUp(){
            level++;
            System.out.println("You´re now level: " + level);
            for (int i = 0; i < level; i++) {
                setHealth(getMaxHealth() + 10);
                setStrength(strength + 1);
                setAgility(agility + 1);
                setIntelligence(intelligence + 1);
        }
            setExperience((experience - 20));

        return level;
    }
}


