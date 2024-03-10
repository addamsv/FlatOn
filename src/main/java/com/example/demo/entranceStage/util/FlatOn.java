package com.example.demo.entranceStage.util;


import java.util.ArrayList;
import java.util.HashMap;

public class FlatOn {
    private int hFlat;
    private int lFlat;
    private int theFlat;
    private int theFloor;
    private int floorsNum = 9;
    private int apartmentsOnFloor;
    private int flStack;
    private int theEntrance;
    private ArrayList<HashMap<String, Object>> entranceList = new ArrayList<HashMap<String, Object>>();

    public void build() {
        if (isFlatNumBelongToDiapason(theFlat, lFlat, hFlat)){
            setStandardProcedure();
            return;
        }

        if (theFlat > 0 && !isFlatDiapason(lFlat, hFlat)){
            int[] retArr = correctLUFlats(theFlat, lFlat, hFlat, floorsNum);
            lFlat = retArr[0];
            hFlat = retArr[1];
            setStandardProcedure();
            return;
        }

        if (isFlatNumNoBelongToDiapason(theFlat, lFlat, hFlat)) {
            theFloor = 0;
            flStack = 0;
            setStandardProcedure();
            return;
        }

        setStandardProcedure();
    }

    public void setStandardProcedure() {
        int[] retEntrance = getEntrance(lFlat, hFlat, floorsNum);
        theEntrance = retEntrance[1];
        apartmentsOnFloor = correctApartmentsOnFloor(lFlat, hFlat, retEntrance[0], floorsNum);

        int[] arr = getFlatStackNdFloor(theFlat, lFlat, hFlat, apartmentsOnFloor, floorsNum);
        theFloor = arr[0];
        flStack = arr[1];

        entranceList.clear();
        makeListOfEntrance(entranceList, lFlat, hFlat, apartmentsOnFloor, floorsNum);
    }

    public void setClear() {
        hFlat = 0;
        lFlat = 0;
        floorsNum = 0;
        theFlat = 0;
    }
    public void setUpperFlat(String upperFlat) {
        hFlat = Integer.parseInt(Util.checkStr(upperFlat));
    }
    public void setLowerFlat(String lowerFlat) {
        lFlat = Integer.parseInt(Util.checkStr(lowerFlat));
    }
    public void setFloors(String floors) {
        floorsNum = Integer.parseInt(Util.checkStr(floors));
    }
    public void setFlatNum(String flatNumber) {
        theFlat = Integer.parseInt(Util.checkStr(flatNumber));
    }
    public String getHowManyFlatsOnFloor(){
        return apartmentsOnFloor + "";
    }
    public String getNumberOfEntrance(){
        return theEntrance + "";
    }
    public String getNumberOfFloor() {
        return theFloor + "";
    }
    public String getHowManyFloors() {
        return floorsNum + "";
    }
    public String getUpperFlat() {
        return Util.checkOutString(hFlat);
    }
    public String getLowerFlat() { return Util.checkOutString(lFlat); }
    public String getFlStack() {
        return flStack + "";
    }
    public String getFlatNum() { return Util.checkOutString(theFlat); }
    public ArrayList<HashMap<String, Object>> getEntranceFlatsList() { return entranceList; }

    public static HashMap<String, Object> makeListData(
            int i, int lFlat, int hFlat, int flatStackOnFloor
    ) {
        HashMap<String, Object> hashMapForEntranceList = new HashMap<String, Object>();
        hashMapForEntranceList.put("hFlat", hFlat);
        hashMapForEntranceList.put("lFlat", lFlat);
        hashMapForEntranceList.put("flatStackOnFloor", flatStackOnFloor + " кв/эт");
        hashMapForEntranceList.put("floorNum", i + "" );

        return hashMapForEntranceList;
    }
    public static void makeListOfEntrance(
            ArrayList<HashMap<String, Object>> listOfEntrance, int lFlat, int hFlat, int apartmentsOnFloor, int floorsNum
    ) {
        if (hFlat == lFlat) { return; }

        int flatStackOnFloorWithinEntranceList;
        int dFlt;

        for (int i = floorsNum; i >= 1; i--) {
            dFlt = hFlat - apartmentsOnFloor + 1;

            if (hFlat == 0) {
                lFlat = 0;
            }

            if (hFlat - apartmentsOnFloor < lFlat) {
                flatStackOnFloorWithinEntranceList = hFlat - lFlat + 1;
                listOfEntrance.add(
                        makeListData(i, lFlat, hFlat, flatStackOnFloorWithinEntranceList)
                );
            } else {
                flatStackOnFloorWithinEntranceList = hFlat - dFlt + 1;
                listOfEntrance.add(
                        makeListData(i, dFlt, hFlat, flatStackOnFloorWithinEntranceList)
                );
            }

            hFlat = hFlat - apartmentsOnFloor;

            if (hFlat < lFlat) {
                hFlat = 0;
            }
        }
    }
    public static int getNumberOfFlatsInEntrance(int lFlat, int hFlat) {
        return hFlat - lFlat <= 0 ? 1 : hFlat - lFlat + 1;
    }
    public static boolean isFlatDiapason(int lFlat, int hFlat) {
        return lFlat > 0 && hFlat > 0 && hFlat > lFlat;
    }
    public static boolean isFlatNumBelongToDiapason(int theFlat, int lFlat, int hFlat) {
        return theFlat > 0 && isFlatDiapason(lFlat, hFlat) && theFlat <= hFlat && theFlat >= lFlat;
    }

    public static boolean isFlatNumNoBelongToDiapason(int theFlat, int lFlat, int hFlat) {
        if (theFlat > 0 && isFlatDiapason(lFlat, hFlat)) {
            return !((theFlat <= hFlat) && (theFlat >= lFlat));
        }
        return true;
    }

    public static int[] getFlatStackNdFloor(
            int theFlat, int lFlat, int hFlat, int apartmentsOnFloor, int floorsNum
    ) {
        int flStack = 0; // #apartment equal 0
        int floor = 0;

        if (hFlat != lFlat) {
            int dFlt;

            for (int i = floorsNum; i >= 1; i--) {
                dFlt = hFlat - apartmentsOnFloor + 1;
                if (hFlat == 0) {
                    lFlat = 0;
                }

                if (theFlat <= hFlat && theFlat >= lFlat) {
                    floor = i; // it's necessary floor

                    if (hFlat - apartmentsOnFloor < lFlat) {
                        flStack = theFlat - lFlat + 1; // warning: different var lFlat nd dFlt
                    } else {
                        flStack = theFlat - dFlt + 1;
                    }
                }

                hFlat = hFlat - apartmentsOnFloor;

                if (hFlat < lFlat) {
                    hFlat = 0;
                }
            }
        }

        return new int[]{floor, flStack};
    }

    public static int[] correctLUFlats(int theFlat, int lFlat, int hFlat, int floorsNum) {
        if (theFlat > 0 && floorsNum > 0) {
            hFlat = floorsNum * 4;

            while (hFlat < theFlat) {
                hFlat = hFlat + floorsNum * 4;
            }

            lFlat = (hFlat - floorsNum * 4) + 1;
        }

        return new int[]{lFlat, hFlat};
    }

    public static int getCalculatedFlats(int floorsNum, int apartmentsOnFloor) {
        return floorsNum * apartmentsOnFloor;
    }
    public static int diff(int flats, int floorsNum, int apartmentsOnFloor) {
        return flats - getCalculatedFlats(floorsNum, apartmentsOnFloor);
    }
    public static int correctApartmentsOnFloor(int lFlat, int hFlat, int apartmentsOnFloor, int floorsNum) {
        int flats = getNumberOfFlatsInEntrance(lFlat, hFlat);

        do {
            if (flats == getCalculatedFlats(floorsNum, apartmentsOnFloor)) {
                break;
            } else if (diff(flats, floorsNum, apartmentsOnFloor) > apartmentsOnFloor + 1) {
                // warning! first stage: num flats!!!
                apartmentsOnFloor++;
                break;
            } else if (diff(flats, floorsNum, apartmentsOnFloor) <= apartmentsOnFloor + 1) {
                // warning! Exception!!!
                apartmentsOnFloor++;
            }
        } while (
                flats == getCalculatedFlats(floorsNum, apartmentsOnFloor)
                        || (diff(flats, floorsNum, apartmentsOnFloor) > apartmentsOnFloor + 1)
        );

        return apartmentsOnFloor;
    }

    public static int[] getEntrance(int lFlat, int hFlat, int floorsNum) {
        if (floorsNum > 0) {
            int apartmentsOnFloor = getNumberOfFlatsInEntrance(lFlat, hFlat) / floorsNum;
            int entrance = (int) Math.round((double) hFlat / getNumberOfFlatsInEntrance(lFlat, hFlat));
            return new int[]{apartmentsOnFloor, entrance};
        }
        return new int[]{0, 0};
    }
}
