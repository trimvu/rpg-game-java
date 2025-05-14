package com.trimvu.rpg;

public class Goblin extends Character {

    public Goblin(String name, String classTitle, int health, int strength, int constitution, int dexterity, int intelligence, int wisdom, int charisma) {
        super(name, classTitle, health, strength, constitution, dexterity, intelligence, wisdom, charisma);
    }

    @Override
    public void attack(Character enemy) {
        System.out.println(getName() + " attacks " + enemy.getName() + " with " + getStrength());
        enemy.setHealth(enemy.getHealth() - this.getStrength());
    }

    @Override
    public void defend(Character enemy) {
        System.out.println(getName() + " the goblin, defends against " + enemy.getName() + " with " + getConstitution());
        int blocked = enemy.getStrength() - this.getConstitution();

        if (blocked > 0) {
            System.out.println(enemy.getName() + " attacked with " + enemy.getStrength() + ", but " + this.getName() + " blocked with " + this.getConstitution() + ". " + blocked + " damage taken");
            this.setHealth(this.getHealth() - blocked);
        } else {
            System.out.println(getName() + " does not take damage");
        }
    }
}
