package com.austinshootthej;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    Player aj = new Player("AJ", 10, 15);
    saveObject(aj);

    aj.setHealth(8);
        System.out.println(aj);
        aj.setWeapon("Staff of Magnus");

        saveObject(aj);
        loadObject(aj);
        System.out.println(aj);



        ISavable werewolf = new Monster("Werewolf", 20, 40);

        // if an object is initialized as an abstract, then it must be cast to an object type in order to use any methods specific to that class
        // that are not present in the interface. 
        System.out.println(((Monster)werewolf).getStrength());

        System.out.println(werewolf);
        saveObject(werewolf);


    }


    public static ArrayList<String> readValues(){
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +"1 to enter a string\n" + "0 to quit");


        while(!quit){
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0:
                    quit = true;
                    break;

                case 1:
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;

    }

    public static void saveObject(ISavable objectToSave){
        for(int i=0; i<objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }

    public static void loadObject(ISavable objectToLoad){
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}
