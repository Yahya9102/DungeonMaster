package com.Yahya.DungeonMaster;


import static com.Yahya.DungeonMaster.Col.ConsoleColors.*;

public class Monster implements ICombat{




        protected static int murlocHp = 100;
        private static int murlocDamage;
        private static String lowLevelMurloc = "Murloc";


        protected static int orcHp = 150;
        private static int orcDamage;
        private static String midLevelOrc = "Orc";



        protected static int jabbaHealth = 175;
        private static int jabbaDamage;
        private static String jabbaName = "Jabba the Hutt";



        public static int getMurlocDamage() {
                return murlocDamage;
        }

        public static void setMurlocDamage(int murlocDamage) {
                Monster.murlocDamage = murlocDamage;
        }

        public static String getLowLevelMurloc() {
                return lowLevelMurloc;
        }



        public static int getOrcDamage() {
                return orcDamage;
        }

        public static void setOrcDamage(int orcDamage) {
                Monster.orcDamage = orcDamage;
        }

        public static String getMidLevelOrc() {
                return midLevelOrc;
        }


        public static int getJabbaDamage() {
                return jabbaDamage;
        }

        public static void setJabbaDamage(int jabbaDamage) {
                Monster.jabbaDamage = jabbaDamage;
        }

        public static String getJabbaName() {
                return jabbaName;
        }


        public void monsterStatus(){

                System.out.println(BLUE + lowLevelMurloc +RESET  + " has: " +BLUE + murlocHp + RESET +" health left");
                System.out.println(BLUE + lowLevelMurloc + RESET+  " does between " +RED_BOLD+ " 1-15 damage " +RESET);
                System.out.println( YELLOW+midLevelOrc + RESET + " has: " + YELLOW + orcHp + RESET + " health left");
                System.out.println( YELLOW +midLevelOrc + RESET+ " does between " +RED_BOLD + " 5-20 damage "+RESET);
                System.out.println(PURPLE + jabbaName + RESET+ " has: " +PURPLE+ jabbaHealth +RESET+ " health left");
                System.out.println(PURPLE +jabbaName + RESET+" does between " + RED_BOLD+ "10-25 damage "+ RESET);
        }


}

