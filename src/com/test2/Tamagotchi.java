package com.test2;

public class Tamagotchi {
    private int hunger;
    private int mood;
    private int fatigue;
    private final int hungerThreshold;
    private final int moodThreshold;
    private final int fatigueThreshold;

    public Tamagotchi(int hungerThreshold, int moodThreshold, int fatigueThreshold) {
        hunger = 0;
        mood = 0;
        fatigue = 0;
        this.hungerThreshold = hungerThreshold;
        this.moodThreshold = moodThreshold;
        this.fatigueThreshold = fatigueThreshold;
    }

    public void play() {
        if(hunger <= hungerThreshold ) {
            hunger += 2;
            mood += 2;
            fatigue += 3;
        }

    }

    public void eat() {
        if(fatigue <= fatigueThreshold) {
                hunger -= 3;
                fatigue += 2;
        }
    }

    public void sleep() {
        if(hunger <= hungerThreshold ) {
            hunger += 1;
            mood += 1;
            fatigue = 0;
        } else {
            hunger += 1;
            mood -= 1;
            fatigue = 0;
        }
    }

    public void pet() {
        hunger += 1;
        mood += 2;
    }
    public String getGeneralCondition() {
        String condition = "indifferent";
        if (mood > moodThreshold) {
            condition = "happy";
        }
        if (hunger > hungerThreshold) {
            condition = "hungry";
        }
        if (fatigue > fatigueThreshold) {
            condition = "tired";
        }
        return condition;
    }

    public void makeHappy() {
        this.eat();
        this.play();
        this.sleep();
    }
}
