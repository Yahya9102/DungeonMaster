package com.Yahya.DungeonMaster;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;

public class EnhetsTester {

    Player player = new Player();
    Fighting fighting = new Fighting();

    @Test
    @DisplayName("Player leveling up")
    public void levelUpTest(){
        assertEquals(player.levelUp(), 1);
    }

  @Test
  @DisplayName("Player dealing damage to Murloc")
  public void damageToMurloc(){

        assertEquals(player.playerAttackMurloc(), 1,26 );
    }

    @Test
    @DisplayName("Player losing a fight and dying")
    public void playerLosingToJabba(){

        for (int i = 0; i < Player.health; i++) {
            assertEquals(fighting.fightingLastBossUntilDeath(),Player.health);
        }

     }
}
