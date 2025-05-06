package com.trimvu.rpg;

public class Fighter extends Character {

    private int strengthBonus;

    public Fighter (String name, int strengthBonus) {
        super (name, 15, 11,7,9,5,2,8);
        this.strengthBonus = strengthBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " the fighter, attacks with " + getStrength());
    }

    @Override
    public void defend() {
        System.out.println(getName() + " the fighter, defends with " + getConstitution());
    }

    public void boostAttack() {
        System.out.println(getName() + " the fighter, boosted attacks with " + getStrengthBonus());
    }

    @Override
    public String toString() {
        return super.toString().replace("Character", "Fighter") +
                ", strengthBonus=" + strengthBonus +
                '}';
    }
}
