package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game_service {
    private int maxState;
    private ArrayList<List> listPatternWin = new ArrayList<>();

    public int getMaxState() {
        return maxState;
    }

    public void setMaxState(int maxState) {
        this.maxState = maxState;
    }

    public ArrayList<List> getListPatternWin() {
        return listPatternWin;
    }

    public void setListPatternWin(ArrayList<List> listPatternWin) {
        this.listPatternWin = listPatternWin;
    }

    public void createPatternWin() {
        System.out.print("Dimension  : ");
        Scanner sc = new Scanner(System.in);
        int dimension = sc.nextInt();
        maxState = dimension * dimension;
        int initCount = 1;
        int endCount = dimension;

        List StraightPattern = new ArrayList();

        // Horizontal & Vertical Pattern
        for (int i = 1; i <= dimension; i++) {
            // Horizontal Pattern
            for (int j = initCount; j <= endCount; j++) {
                StraightPattern.add(j);
                initCount++;
            }
            endCount = endCount + dimension;
            listPatternWin.add(new ArrayList(StraightPattern));
            StraightPattern.clear();

            // Vertical Pattern
            for (int j = i; j <= maxState; j = j + dimension) {
                StraightPattern.add(j);
            }
            listPatternWin.add(new ArrayList(StraightPattern));
            StraightPattern.clear();
        }

        // Diagonal Pattern 1
        for (int j = 1; j <= maxState; j = (j + dimension) + 1) {
            StraightPattern.add(j);
        }
        listPatternWin.add(new ArrayList(StraightPattern));
        StraightPattern.clear();

        // Diagonal Pattern 2
        for (int j = dimension; j <= maxState - (dimension - 1); j = (j + dimension) - 1) {
            StraightPattern.add(j);
        }
        listPatternWin.add(new ArrayList(StraightPattern));
        StraightPattern.clear();

        System.out.println("Pattern win : " + listPatternWin + "\n");
    }

    public String checkWin(ArrayList<List> listPatternWin, ArrayList<Integer> playerFullState, ArrayList<Integer> cpuFullState, int maxState) {
        for (List x : listPatternWin) {
            if (playerFullState.containsAll(x)) {
                return "Congrataulation, you win !!";
            } else if (cpuFullState.containsAll(x)) {
                return "Sorry, you lose !!";
            } else if (playerFullState.size() + cpuFullState.size() == maxState) {
                return "Result of a draw";
            }
        }
        return "";
    }
}
