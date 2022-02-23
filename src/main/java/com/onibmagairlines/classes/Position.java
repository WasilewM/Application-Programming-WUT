package com.onibmagairlines.classes;

import com.onibmagairlines.javafx.MainWindow;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Position {

    private int positionID;
    private String positionName;

    public Position(int positionID, String positionName) {
        this.setPositionID(positionID);
        this.setPositionName(positionName);
    }

    public int getPositionID() {
        return positionID;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionID(int positionID) throws IllegalArgumentException {
        if (positionID >= 0 && positionID < 100) {
            this.positionID = positionID;
        } else {
            throw new IllegalArgumentException("PositionID must be a number from 0 to 99.");
        }
    }

    public void setPositionName(String positionName) throws IllegalArgumentException {
        if (positionName.length() > 0 && positionName.length() <= 40) {
            this.positionName = positionName;
        }
        else {
            throw new IllegalArgumentException("Position name must contain from 1 to maximum of 40 characters.");
        }
    }

    public static String getDatabaseTableName() {
        return "positions";
    }

    public static String[] getDatabaseFields() {
        return new String[] {"POSITION_ID", "NAME"};
    }

    public static Position createOneObjectFromList(ArrayList<Object> list) {
        return new Position(
                ((BigDecimal) list.get(0)).intValue(),  // positionID
                (String) list.get(1)    // positionName
        );
    }

    public static ArrayList<Position> createMultipleObjectsFromList(ArrayList<ArrayList<Object>> list) {
        ArrayList<Position> objects = new ArrayList<>();
        for (var row: list) {
            objects.add(Position.createOneObjectFromList(row));
        }
        return objects;
    }
}
