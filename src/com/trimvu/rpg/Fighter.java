package com.trimvu.rpg;

public class Fighter extends Character {

    private int strengthBonus;
    private int bonusAvailable;

    public Fighter (String name, int strengthBonus, int bonusAvailable) {
        super (name, 15, 11,7,9,5,2,8);
        this.strengthBonus = strengthBonus;
        this.bonusAvailable = bonusAvailable;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }

    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    public int getBonusAvailable() {
        return bonusAvailable;
    }

    public void setBonusAvailable(int bonusAvailable) {
        this.bonusAvailable = bonusAvailable;
    }

    @Override
    public void attack(Character enemy) {
        System.out.println(getName() + " the fighter, attacks " + enemy.getName() + " with " + getStrength());
        enemy.setHealth(enemy.getHealth() - this.getStrength());
    }

    @Override
    public void defend(Character enemy) {
        System.out.println(getName() + " the fighter, defends against " + enemy.getName() + " with " + getConstitution());
        int blocked = enemy.getStrength() - this.getConstitution();

        if (blocked > 0) {
            System.out.println(enemy.getName() + " attacked with " + enemy.getStrength() + ", but " + this.getName() + " blocked with " + this.getConstitution() + ". " + blocked + " damage taken");
            this.setHealth(this.getHealth() - blocked);
        } else {
            System.out.println(getName() + " does not take damage");
        }
    }

    public void boostAttack(Character enemy) {
        if (bonusAvailable > 0) {
            System.out.println(getName() + " the fighter, boosted attacks with " + getStrengthBonus());
            int damage = getStrength() + getStrengthBonus();
            enemy.setHealth(enemy.getHealth() - damage);
            bonusAvailable--;
        } else {
            System.out.println(getName() + " does not have any bonus attacks left");
        }
    }

    @Override
    public String toString() {
        return super.toString().replace("Character", "Fighter") +
                "strengthBonus=" + strengthBonus +
                ", bonusAvailable=" + bonusAvailable +
                '}';
    }
}
