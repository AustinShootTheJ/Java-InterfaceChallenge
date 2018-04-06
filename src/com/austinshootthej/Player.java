package com.austinshootthej;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISavable {
    private String name;
    private int hitPoints;
    private int strength;
    private String weapon;


    public Player(String name, int health, int strength) {
        this.name = name;
        this.hitPoints = health;
        this.strength = strength;
        this.weapon = "Sword";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return hitPoints;
    }

    public void setHealth(int health) {
        this.hitPoints = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength );
        values.add(3, this.weapon);



        return values;
    }

    @Override
    public void read(List<String> savedValues) {

        if(savedValues != null && savedValues.size() > 0){
            this.name = savedValues.get(0);
            this.hitPoints = Integer.parseInt(savedValues.get(1));
            this.strength = Integer.parseInt(savedValues.get(2));
            this.weapon = savedValues.get(3);
        }


    }
}
