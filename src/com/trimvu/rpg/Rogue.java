package com.trimvu.rpg;

import java.util.Random;

public class Rogue extends Character {

    private int sneak;

    public Rogue (String name, int sneak) {
        super(name, 9,7,2,11,8,5,15);
        this.sneak = sneak;
    }

    public int getSneak() {
        return sneak;
    }

    public void setSneak(int sneak) {
        this.sneak = sneak;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " the rogue, attacks with " + getStrength());
    }

    @Override
    public void defend() {
        System.out.println(getName() + " the rogue, defends with " + getConstitution());
    }

    public void hide(Character enemy) {
        Random random = new Random();
        int randomNum = random.nextInt(21);

        if (randomNum < getSneak()) {
            System.out.println(getName() + " the rogue, was able to successfully hide");
        } else {
            System.out.println(getName() + " the rouge, was unable to hide");
            enemy.attack();
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("Character", "Rogue") +
                "sneak=" + sneak +
                '}';
    }
}
