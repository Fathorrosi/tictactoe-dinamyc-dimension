package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private int tempState;
    private ArrayList<Integer> fullState;

    public Player(String name, int tempState, ArrayList<Integer> fullState) {
        this.name = name;
        this.tempState = tempState;
        this.fullState = fullState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTempState() {
        return tempState;
    }

    public void setTempState(int tempState) {
        this.tempState = tempState;
    }

    public ArrayList<Integer> getFullState() {
        return fullState;
    }

    public void setFullState(ArrayList<Integer> fullState) {
        this.fullState = fullState;
    }
}

