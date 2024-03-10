package com.example.demo.entranceStage;

import java.util.ArrayList;
import java.util.HashMap;

/*
const out = {
    theFlat: 413,
    floors: 9,
    theFloor: 5,
    lFlat: 397,
    hFlat: 432,
    onFloor: 1,
    flatsOnFloor: 4,
    entrance: 12,
    entranceList: [
        {lFlat: 429, flatsOnFloor: 4, hFlat: 432, floor: 9},
        {lFlat: 425, flatsOnFloor: 4, hFlat: 428, floor: 8},
        {lFlat: 421, flatsOnFloor: 4, hFlat: 424, floor: 7},
        {lFlat: 417, flatsOnFloor: 4, hFlat: 420, floor: 6},
        {lFlat: 413, flatsOnFloor: 4, hFlat: 416, floor: 5},
        {lFlat: 409, flatsOnFloor: 4, hFlat: 412, floor: 4},
        {lFlat: 405, flatsOnFloor: 4, hFlat: 408, floor: 3},
        {lFlat: 401, flatsOnFloor: 4, hFlat: 404, floor: 2},
        {lFlat: 397, flatsOnFloor: 4, hFlat: 400, floor: 1}
    ]
}
*/
public class EntranceStage {
    private Long id;
    private String theFlat;
    private String floors;
    private String theFloor;
    private String lFlat;
    private String hFlat;
    private String onFloor;
    private String flatsOnFloor;
    private String entrance;
    private ArrayList<HashMap<String, Object>> entranceList;

    public EntranceStage(Long id,
                  String theFlat,
                  String floors,
                  String theFloor,
                  String lFlat,
                  String hFlat,
                  String onFloor,
                  String flatsOnFloor,
                  String entrance,
                  ArrayList<HashMap<String, Object>> entranceList) {
        this.id = id;
        this.theFlat = theFlat;
        this.floors = floors;
        this.theFloor = theFloor;
        this.lFlat = lFlat;
        this.hFlat = hFlat;
        this.onFloor = onFloor;
        this.flatsOnFloor = flatsOnFloor;
        this.entrance = entrance;
        this.entranceList = entranceList;
    }
    public EntranceStage(String theFlat,
                  String floors,
                  String theFloor,
                  String lFlat,
                  String hFlat,
                  String onFloor,
                  String flatsOnFloor,
                  String entrance,
                  ArrayList<HashMap<String, Object>> entranceList) {
        this.theFlat = theFlat;
        this.floors = floors;
        this.theFloor = theFloor;
        this.lFlat = lFlat;
        this.hFlat = hFlat;
        this.onFloor = onFloor;
        this.flatsOnFloor = flatsOnFloor;
        this.entrance = entrance;
        this.entranceList = entranceList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTheFlat(String theFlat) {
        this.theFlat = theFlat;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public void setTheFloor(String theFloor) {
        this.theFloor = theFloor;
    }

    public void setlFlat(String lFlat) {
        this.lFlat = lFlat;
    }

    public void sethFlat(String hFlat) {
        this.hFlat = hFlat;
    }

    public void setOnFloor(String onFloor) {
        this.onFloor = onFloor;
    }

    public void setFlatsOnFloor(String flatsOnFloor) {
        this.flatsOnFloor = flatsOnFloor;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public void setEntranceList(ArrayList<HashMap<String, Object>> entranceList) {
        this.entranceList = entranceList;
    }

    public Long getId() {
        return id;
    }

    public String getTheFlat() {
        return theFlat;
    }

    public String getFloors() {
        return floors;
    }

    public String getTheFloor() {
        return theFloor;
    }

    public String getlFlat() {
        return lFlat;
    }

    public String gethFlat() {
        return hFlat;
    }

    public String getOnFloor() {
        return onFloor;
    }

    public String getFlatsOnFloor() {
        return flatsOnFloor;
    }

    public String getEntrance() {
        return entrance;
    }

    public ArrayList<HashMap<String, Object>> getEntranceList() {
        return entranceList;
    }

    @Override
    public String toString() {
        return "FlatOn{" +
                "id=" + id +
                ", theFlat='" + theFlat + '\'' +
                ", floors='" + floors + '\'' +
                ", theFloor='" + theFloor + '\'' +
                ", lFlat='" + lFlat + '\'' +
                ", hFlat='" + hFlat + '\'' +
                ", onFloor='" + onFloor + '\'' +
                ", flatsOnFloor='" + flatsOnFloor + '\'' +
                ", entrance='" + entrance + '\'' +
                ", entranceList=" + entranceList +
                '}';
    }

    public EntranceStage() {}
}
