package com.trimvu.rpg;

import java.util.Random;

public class Rogue extends Character {

    private int sneak;
    private boolean hidden;
    private int turnsHidden;

    public Rogue (String name, int sneak) {
        super(name, 9,7,2,11,8,5,15);
        this.sneak = sneak;
        this.hidden = false;
    }

    public int getSneak() {
        return sneak;
    }

    public void setSneak(int sneak) {
        this.sneak = sneak;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getTurnsHidden() {
        return turnsHidden;
    }

    public void setTurnsHidden(int turnsHidden) {
        this.turnsHidden = turnsHidden;
    }

    @Override
    public void attack(Character enemy) {
        if (hidden && turnsHidden > 0) {
            System.out.println(getName() + " the rogue, attacks " + enemy.getName() + " with " + getStrength());
            enemy.setHealth(enemy.getHealth() - this.getStrength());
            turnsHidden--;
        } else {
            System.out.println(getName() + " the rogue, attacks " + enemy.getName() + " with " + getStrength());
            enemy.setHealth(enemy.getHealth() - this.getStrength());
        }
    }

    @Override
    public void defend(Character enemy) {
        System.out.println(getName() + " the rogue, defends against " + enemy.getName() + " with " + getConstitution());
        int blocked = enemy.getStrength() - this.getConstitution();

        if (blocked > 0) {
            System.out.println(enemy.getName() + " attacked with " + enemy.getStrength() + ", but " + this.getName() + " blocked with " + this.getConstitution() + ". " + blocked + " damage taken");
            this.setHealth(this.getHealth() - blocked);
        } else {
            System.out.println(getName() + " does not take damage");
        }
    }

    public void hide(Character enemy) {
        Random random = new Random();
        int randomNum = random.nextInt(21);

        if (randomNum < getSneak()) {
            System.out.println(getName() + " the rogue, was able to successfully hide");
            setHidden(true);
            setTurnsHidden(3);
        } else {
            System.out.println(getName() + " the rogue, was unable to hide");
            setHidden(false);
            enemy.attack(this);
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("Character", "Rogue") +
                "sneak=" + sneak +
                ", hidden=" + hidden +
                '}';
    }
}
