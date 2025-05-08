package com.trimvu.rpg;

public class Main {
    public static void main(String[] args) {
        Fighter fighter = new Fighter("Aragon", 5,3);

        System.out.println(fighter);

        Wizard wizard = new Wizard("Gandalf", 5,3);

        System.out.println(wizard);

        Rogue rogue = new Rogue("Frodo", 5);

        System.out.println(rogue);

        System.out.println(wizard.getHealth());
        fighter.attack(wizard);
        System.out.println(wizard.getHealth());

    }
}