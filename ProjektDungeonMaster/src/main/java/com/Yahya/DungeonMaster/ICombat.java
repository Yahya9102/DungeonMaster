package com.Yahya.DungeonMaster;

import java.util.Random;

import static com.Yahya.DungeonMaster.Col.ConsoleColors.*;
import static com.Yahya.DungeonMaster.Monster.*;
import static com.Yahya.DungeonMaster.Player.*;

public interface ICombat {

    default void namePicking(){

        Player player = new Player();
        player.setPlayerName();

    }

     default void murlocAttack(){

             Random attack = new Random();
             System.out.println(getLowLevelMurloc() + " Attacking ");
             attack.nextInt();
             setMurlocDamage(attack.nextInt(1, 15));
             System.out.println(getLowLevelMurloc() + " did " +RED_BOLD + getMurlocDamage() +RESET+ " damage to " + getPlayerName());

             if (getMurlocDamage() == 15) {
                 System.out.println(getLowLevelMurloc() + " did a critical hit of " +RED_BOLD+ (getMurlocDamage() + 5)+RESET);
             } else if (getMurlocDamage() == getAgility()) {
                 System.out.println(BLUE+getPlayerName() + " dodged your attack" + RESET);
                 health += getMurlocDamage();
             }

             health = health - getMurlocDamage();
             System.out.println(getPlayerName() + " has " + YELLOW_BOLD + health + " health left " + RESET);

             if (health <= 0) {
                 System.out.println(RED_BOLD + getPlayerName() + " has died" + RESET);
             }
         }



    default void orcAttack(){
            Random attack = new Random();
            System.out.println(getMidLevelOrc() + " Attacking ");
            attack.nextInt();
            setOrcDamage(attack.nextInt(5, 20));
            System.out.println(getMidLevelOrc() + " did " + RED+ getOrcDamage() + RESET +" damage to " + getPlayerName());

            if (getOrcDamage() == 15) {
                System.out.println(getMidLevelOrc() + " did a critical hit of " + RED_BOLD + (getOrcDamage() + 5) +RESET);
            } else if (getOrcDamage() == getAgility()) {
                System.out.println(getPlayerName() + " dodged the attack");
                health += getOrcDamage();
            }
            health = health - getOrcDamage();

            System.out.println(getPlayerName() + " has " + YELLOW_BOLD + health + " health left " + RESET);

            if (health <= 0) {
                System.out.println(RED_BOLD +getPlayerName() + " has died"+ RESET);

            }

        }



    default void jabbaAttack(){

            Random attack = new Random();
            System.out.println(getJabbaName() + " Attacking ");
            attack.nextInt();
            setJabbaDamage(attack.nextInt(10, 25));
            System.out.println(getJabbaName() + " did " + RED_BOLD + getJabbaDamage() +RESET +" damage to " + getPlayerName());

            if (getJabbaDamage() == 25) {
                System.out.println(getJabbaName() + " did a critical hit of " + RED_BRIGHT+ (getJabbaDamage() + getJabbaDamage()) + RESET);
            } else if (getJabbaDamage() == getAgility()) {
                System.out.println(BLUE +getPlayerName() + " dodged your attack" + RESET);
                health += getJabbaDamage();
            }

            health = health - getJabbaDamage();
            System.out.println(getPlayerName() + " has " + YELLOW_BOLD + health + " health left " + RESET);

            if (health <= 0) {
                System.out.println(RED_BOLD + getPlayerName() + " has died" + RESET);

            }



        }

    default void jabbaAttackUntilDeath(){

        Random attack = new Random();
        System.out.println(getJabbaName() + " Attacking ");
        attack.nextInt();
        setJabbaDamage(attack.nextInt(10, 25));
        System.out.println(getJabbaName() + " did " + RED_BOLD + getJabbaDamage() + RESET +" damage to " + getPlayerName());

        if (getJabbaDamage() == 25) {
            System.out.println(getJabbaName() + " did a critical hit of " + (getJabbaDamage() + getJabbaDamage()));
        } else if (getJabbaDamage() == getAgility()) {
            System.out.println(BLUE + getPlayerName() + " dodged your attack" + RESET);
            health += getJabbaDamage();
        }
        health = health - getJabbaDamage();
        System.out.println(getPlayerName() + " has " + YELLOW_BOLD + health + " health left " + RESET);

        if (health <= 0) {
            System.out.println(RED_BOLD + getPlayerName() + " has died" + RESET);
        }
    }
}


