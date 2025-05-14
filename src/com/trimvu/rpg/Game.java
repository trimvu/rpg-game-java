package com.trimvu.rpg;

import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    boolean running = true;

    public void start() {
        System.out.print("What is your character's name?: ");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.print("Please enter your character's name: ");
            name = scanner.nextLine();
        }
        System.out.println("Hello, " + name + "!");
        System.out.println("What is your class? Please enter the numerical value associated to the class: ");
        System.out.println("1. Fighter");
        System.out.println("2. Wizard");
        System.out.println("3. Rogue");
        System.out.print("> ");
        int number = scanner.nextInt();

        Character mainCharacter = null;

        switch (number) {
            case 1 -> mainCharacter = new Fighter(name, "Fighter",3,3);
            case 2 -> mainCharacter = new Wizard(name, "Wizard",3,3);
            case 3 -> mainCharacter = new Rogue(name, "Rogue", 3);
            default -> System.out.println(number + " is not a valid option!");
        }

        if (mainCharacter != null) {
            System.out.println("Your character info: ");
            System.out.println(mainCharacter.getName() + ": the " + mainCharacter.getClassTitle());
        }

        while (running) {

            nextActionRequest();
            int action = scanner.nextInt();
            nextActionResponse(action, mainCharacter);

        }
    }

    public void nextActionRequest() {
        System.out.println("What would you like to do?: ");
        System.out.println("1. Fight Goblins");
        System.out.println("2. Get Potion");
        System.out.println("3. View Character Stats");
        System.out.println("4. Quit Game");
        System.out.print("> ");
    }

    public void battle(Character hero) {
        Goblin goblin = new Goblin("Goblin", "Goblin", 50, 5,5,5,5,5,5);
        System.out.println("A Goblin appears.");

        while (hero.getHealth() > 0 && goblin.getHealth() > 0) {
            System.out.println("Your health: " + hero.getHealth());
            System.out.println("Goblin's health: " + goblin.getHealth());
            System.out.println("What is your next action?: ");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Special");
            System.out.println("4. View Stats");
            System.out.print("> ");

            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 1 -> {
                    hero.attack(goblin);
                    System.out.println("Your health: " + hero.getHealth());
                    System.out.println("Goblin's health: " + goblin.getHealth());
                }
                case 2 -> hero.defend(goblin);
                case 3 -> {
                    if (hero instanceof Fighter fighter) {
                        fighter.boostAttack(goblin);
                    } else if (hero instanceof  Wizard wizard) {
                        System.out.println("Which one of the Goblin's stat would you like to reduce?: ");
                        System.out.println("1. Strength");
                        System.out.println("2. Constitution");
                        System.out.println("3. Dexterity");
                        System.out.println("4. Intelligence");
                        System.out.println("5. Wisdom");
                        System.out.println("6. Charisma");
                        System.out.print("> ");

                        int input = scanner.nextInt();

                        switch (input) {
                            case 1 -> wizard.reduceStatSpell(goblin, "strength");
                            case 2 -> wizard.reduceStatSpell(goblin, "constitution");
                            case 3 -> wizard.reduceStatSpell(goblin, "dexterity");
                            case 4 -> wizard.reduceStatSpell(goblin, "intelligence");
                            case 5 -> wizard.reduceStatSpell(goblin, "wisdom");
                            case 6 -> wizard.reduceStatSpell(goblin, "charisma");
                            default -> {
                                System.out.println("Not a valid input.");
                                System.out.println();
                            }
                        }
                    } else if (hero instanceof  Rogue rogue) {
                        rogue.hide(goblin);
                    }
                }
                case 4 -> viewBattleStats(hero, goblin);
                default -> {
                    System.out.println(action + " is not a valid option");
                    System.out.println();
                }
            }
        }
    }

    public void nextActionResponse(int num, Character mainCharacter) {
        switch (num) {
            case 1 -> battle(mainCharacter);
            case 2 -> System.out.println("hello 2");
            case 3 -> viewCharacterStats(mainCharacter);
            case 4 -> {
                System.out.println("Goodbye!");
                running = false;
            }
            default -> System.out.println("Not a valid option .");
        }
    }

    public void viewCharacterStats(Character hero) {
        System.out.println(hero.getName() + "'s stats: ");
        System.out.println("Health: " + hero.getHealth());
        System.out.println("Strength: " + hero.getStrength());
        System.out.println("Constitution: " + hero.getConstitution());
        System.out.println("Dexterity: " + hero.getDexterity());
        System.out.println("Intelligence: " + hero.getIntelligence());
        System.out.println("Wisdom: " + hero.getWisdom());
        System.out.println("Charisma: " + hero.getCharisma());
        System.out.println();
    }

    public void viewBattleStats(Character hero, Character goblin) {
        viewCharacterStats(hero);
        System.out.println(goblin.getName() + "'s stats: ");
        System.out.println("Health: " + goblin.getHealth());
        System.out.println("Strength: " + goblin.getStrength());
        System.out.println("Constitution: " + goblin.getConstitution());
        System.out.println("Dexterity: " + goblin.getDexterity());
        System.out.println("Intelligence: " + goblin.getIntelligence());
        System.out.println("Wisdom: " + goblin.getWisdom());
        System.out.println("Charisma: " + goblin.getCharisma());
        System.out.println();
    }

}
