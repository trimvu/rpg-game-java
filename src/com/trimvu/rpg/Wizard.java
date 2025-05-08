package com.trimvu.rpg;

public class Wizard extends Character {

    private int spellStrength;
    private int availableSpells;

    public Wizard (String name, int spellStrength, int availableSpells) {
        super(name, 12,2,8,7,15,11,5);
        this.spellStrength = spellStrength;
        this.availableSpells = availableSpells;
    }

    public int getSpellStrength() {
        return spellStrength;
    }

    public void setSpellStrength(int spellStrength) {
        this.spellStrength = spellStrength;
    }

    public int getAvailableSpells() {
        return availableSpells;
    }

    public void setAvailableSpells(int availableSpells) {
        this.availableSpells = availableSpells;
    }

    @Override
    public void attack(Character enemy) {
        System.out.println(getName() + " the wizard, attacks " + enemy.getName() + " with " + getStrength());
        enemy.setHealth(enemy.getHealth() - this.getStrength());
    }

    @Override
    public void defend(Character enemy) {
        System.out.println(getName() + " the wizard, defends against " + enemy.getName() + " with " + getConstitution());
        int blocked = enemy.getStrength() - this.getConstitution();

        if (blocked > 0) {
            System.out.println(enemy.getName() + " attacked with " + enemy.getStrength() + ", but " + this.getName() + " blocked with " + this.getConstitution() + ". " + blocked + " damage taken");
            this.setHealth(this.getHealth() - blocked);
        } else {
            System.out.println(getName() + " does not take damage");
        }
    }

    public void reduceStatSpell(Character enemy, String stat) {
        if (availableSpells <= 0) {
            System.out.println(getName() + " has no spells left!");
            return;
        }

        int originalValue;
        int reducedValue;

        switch (stat.toLowerCase()) {
            case "strength":
                originalValue = enemy.getStrength();
                reducedValue = Math.max(0, originalValue - spellStrength);
                enemy.setStrength(reducedValue);
                break;
            case "constitution":
                originalValue = enemy.getConstitution();
                reducedValue = Math.max(0, originalValue - spellStrength);
                enemy.setConstitution(reducedValue);
                break;
            case "dexterity":
                originalValue = enemy.getDexterity();
                reducedValue = Math.max(0, originalValue - spellStrength);
                enemy.setDexterity(reducedValue);
                break;
            case "intelligence":
                originalValue = enemy.getIntelligence();
                reducedValue = Math.max(0, originalValue - spellStrength);
                enemy.setIntelligence(reducedValue);
                break;
            case "wisdom":
                originalValue = enemy.getWisdom();
                reducedValue = Math.max(0, originalValue - spellStrength);
                enemy.setWisdom(reducedValue);
                break;
            case "charisma":
                originalValue = enemy.getCharisma();
                reducedValue = Math.max(0, originalValue - spellStrength);
                enemy.setCharisma(reducedValue);
                break;
            default:
                System.out.println("Invalid stat: " + stat);
                return;
        }

        System.out.println(getName() + " reduces " + enemy.getName() + "'s " + stat + " from " + originalValue + " to " + reducedValue);
        availableSpells--;
    }

    @Override
    public String toString() {
        return super.toString().replace("Character", "Wizard") +
                "spellStrength=" + spellStrength +
                ", availableSpells=" + availableSpells +
                '}';
    }
}
