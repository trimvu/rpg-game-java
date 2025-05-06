package com.trimvu.rpg;

public class Wizard extends Character {

    private int spellStrength;

    public Wizard (String name, int spellStrength) {
        super(name, 12,2,8,7,15,11,5);
        this.spellStrength = spellStrength;
    }

    public int getSpellStrength() {
        return spellStrength;
    }

    public void setSpellStrength(int spellStrength) {
        this.spellStrength = spellStrength;
    }

    @Override
    public void attack() {
        System.out.println(getName() + " the mage, attacks with " + getStrength());
    }

    @Override
    public void defend() {
        System.out.println(getName() + " the mage, defends with " + getConstitution());
    }

    public void reduceStrengthSpell() {
        System.out.println(getName() + " the mage, reduces enemy strength by " + getSpellStrength());
    }

    public void reduceConstitutionSpell() {
        System.out.println(getName() + " the mage, reduces enemy constitution by " + getSpellStrength());
    }

    public void reduceDexteritySpell() {
        System.out.println(getName() + " the mage, reduces enemy dexterity by " + getSpellStrength());
    }

    public void reduceIntelligenceSpell() {
        System.out.println(getName() + " the mage, reduces enemy intelligence by " + getSpellStrength());
    }

    public void reduceWisdomSpell() {
        System.out.println(getName() + " the mage, reduces enemy wisdom by " + getSpellStrength());
    }

    public void reduceCharismaSpell() {
        System.out.println(getName() + " the mage, reduces enemy charisma by " + getSpellStrength());
    }

    @Override
    public String toString() {
        return super.toString().replace("Character", "Wizard") +
                "spellStrength=" + spellStrength +
                '}';
    }
}
