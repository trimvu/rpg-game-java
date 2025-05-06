package com.trimvu.rpg;

public class Main {
    public static void main(String[] args) {
        Fighter fighter = new Fighter("Aragon", 5);

        System.out.println(fighter);
        fighter.attack();
        fighter.defend();
        fighter.boostAttack();

        Wizard wizard = new Wizard("Gandalf", 5);

        System.out.println(wizard);
        wizard.attack();
        wizard.defend();
        wizard.reduceDexteritySpell();

        Rogue rogue = new Rogue("Frodo", 5);

        System.out.println(rogue);
        rogue.attack();
        rogue.defend();
        rogue.hide(wizard);
    }
}