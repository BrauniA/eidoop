package com.test2;

public class Main {

    public static void main(String[] args) {
	Tamagotchi tamagotchi = new Tamagotchi(0,0,0);
	System.out.println(tamagotchi.getGeneralCondition());
	tamagotchi.makeHappy();
    System.out.println(tamagotchi.getGeneralCondition());


    }
}
