package com.a_adam.displMessage.FlatOn;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.SimpleAdapter;
//import android.widget.Toast;
//import com.a_adam.displMessage.R;
//import com.mikepenz.materialdrawer.Drawer;

import com.a_adam.displMessage.Utils.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;

// 92:12:31:47:AF:51:DA:F3:E5:23:AB:73:33:EC:0B:40:78:7D:CE:ED
// AIzaSyA_FQLVPJL8v_TUUXKW0A8jll0IDwfIXiw

public class FlatOn {
    private String TITLE = "name1";                // ut text
    private String TITLE2 = "name2";              // down text
    private String DESCRIPTION = "description";    // lower the main
    private String ICON = "icon";                  // image that will be
    private int hiFlat;
    private int dwnFlat;
    private int flatNum;
    private int floor;           // floor that we need!
    private int floorsNum = 9;       // how many stages entrance have
    private int apartmentsOnFloor;  // how many apartments on the stage
    private int entrance;        // hiFlat / deltaFlat
    private int flStack;

    private ArrayList<HashMap<String, Object>> entranceList = new ArrayList<HashMap<String, Object>>();


//    public

    public Boolean build() {
        if (isFlatNumBelongToDiapason()){
            setStandardProcedure();
            Log.d("Awesome", "1 first time we're here");
            return true;
        }

        if (isFlatNum() && !isFlatDiapason()){

            Log.d("Awesome", "2 first time we're here");
            correctLUFlats();
            setStandardProcedure();
            return true;
        }

        if (isFlatNumNoBelongToDiapason()){
            floor = 0;
            flStack = 0;
            setStandardProcedure();

            Log.d("Awesome", "3 first time we're here");
            return true;
        }

        Log.d("Awesome", "4 first time we're here");
        setStandardProcedure();
        return true;
    }

    public void setClear() {
        clearFlatDiapasonData();
        this.floorsNum = 0;
        this.flatNum = 0;
    }

    public void setUpperFlat(String upperFlat) {
        this.hiFlat = Integer.parseInt(checkStr(upperFlat));
    }

    public void setLowerFlat(String lowerFlat) {
        this.dwnFlat = Integer.parseInt(checkStr(lowerFlat));
    }
    public void setFloors(String floors) {
        this.floorsNum = Integer.parseInt(checkStr(floors));
    }
    public void setFlatNum(String flatNum) {
        this.flatNum = Integer.parseInt(checkStr(flatNum));
    }

    public String getHowManyFlatsOnFloor(){
        return apartmentsOnFloor + "";
    }
    public String getNumberOfEntrance(){
        return entrance + "";
    }
    public String getNumberOfFloor() {
        return floor + "";
    }
    public String getHowManyFloors() {
        return floorsNum +"";
    }
    public String getUpperFlat() {
        return checkOutString(hiFlat);
    }
    public String getLowerFlat() { return checkOutString(dwnFlat); }
    public String getFlStack() {
        return flStack + "";
    }
    public String getFlatNum() { return checkOutString(flatNum); }
//    public SimpleAdapter getEntranceFlatsList(Context context) { return get(context); }
    public ArrayList<HashMap<String, Object>> getEntranceFlatsList() { return entranceList; }



//    private


    private String checkStr(String val) { return (StringUtil.isEmpty(val)) ? "0" : val; }

    private String getStr(EditText field) { return field.getText().toString().trim(); }

    private String checkOutString(int val) {
        if (StringUtil.isEmpty(val  + "")) {
            return "0";
        }
        return val + "";
    }

    private int howMuchFlatsOnEntranceCalculated() { return floorsNum * apartmentsOnFloor; }

    private int howMuchFlatsOnEntranceReal() {
        return (hiFlat - dwnFlat <= 0) ? 1 : hiFlat - dwnFlat + 1;
    }

    private boolean isFlatNum() { return flatNum > 0; }

    private boolean isUpperFlatGreaterThanLowerFlat() { return hiFlat > dwnFlat; }

    private boolean isLowerFlat() { return  dwnFlat > 0; }

    private boolean isUpperFlat() { return  hiFlat > 0; }

    private void clearFlatDiapasonData() {
        this.hiFlat = 0;
        this.dwnFlat = 0;
    }

    private boolean isFlatDiapason() {
        return (isLowerFlat() && isUpperFlat() && isUpperFlatGreaterThanLowerFlat());
    }

    private boolean isFlatNumBelongToDiapason() {
        return isFlatNum() && isFlatDiapason() && ((flatNum <= hiFlat) && (flatNum >= dwnFlat));
    }

    private boolean isFlatNumNoBelongToDiapason() {
        if (isFlatNum() && isFlatDiapason()) {
            return !((flatNum <= hiFlat) && (flatNum >= dwnFlat));
        }
        return true;
    }

    private void putListData(int i, int hFlat, int dFlat, int flatStackOnFloor) {
        HashMap<String, Object> hashMapForEntranceList = new HashMap<String, Object>();
        hashMapForEntranceList.put(TITLE, hFlat);
        hashMapForEntranceList.put(TITLE2, dFlat);
        hashMapForEntranceList.put(DESCRIPTION, flatStackOnFloor + " кв/эт");
        hashMapForEntranceList.put(ICON, i + "" );
        entranceList.add(hashMapForEntranceList);
    }

    private void clearListData() { entranceList.clear(); }

    private boolean listData() {
        // flStack = 0; #apartment equal 0; clearListData has been set up on another function
        if (hiFlat != dwnFlat) {
            int flatStackOnFloorWithinEntranceList;
            int dFlt;
            int hFlat = hiFlat;
            int dFlat = dwnFlat;

            for (int i = floorsNum; i >= 1; i--) {
                dFlt = hFlat - apartmentsOnFloor + 1;

                if (hFlat == 0) {
                    dFlat = 0;
                }

                if ((hFlat - apartmentsOnFloor) < dFlat) {
                    flatStackOnFloorWithinEntranceList = hFlat - dFlat + 1;
                    putListData(i, hFlat, dFlat, flatStackOnFloorWithinEntranceList);
                } else {
                    flatStackOnFloorWithinEntranceList = hFlat - dFlt + 1;
                    putListData(i, hFlat, dFlt, flatStackOnFloorWithinEntranceList);
                }

                hFlat = hFlat - apartmentsOnFloor;

                if (hFlat < dFlat) {
                    hFlat = 0;
                }
            }

            return true;
        }
        return false;
    }

    private void setFlatStackNdListDataNdNecessaryFloor() {
        clearListData();
        flStack = 0; // #apartment equal 0

        if (isFlatNum()) {
            if (hiFlat != dwnFlat) {
                int flatStackOnFloorWithinEntranceList;
                int dFlt;
                int hFlat = hiFlat;
                int dFlat = dwnFlat;

                for (int i = floorsNum; i >= 1; i--) {
                    dFlt = hFlat - apartmentsOnFloor + 1;
                    if (hFlat == 0) {
                        dFlat = 0;
                    }

                    if ((flatNum <= hFlat) && (flatNum >= dFlat)) {
                        floor = i; // it's necessary floor

                        if ((hFlat - apartmentsOnFloor) < dFlat) {
                            flStack = flatNum - dFlat + 1;//warning: different var dFlaaaat nd dFlt
                        } else {
                            flStack = flatNum - dFlt + 1;
                        }
                    }

                    if ((hFlat - apartmentsOnFloor) < dFlat) {
                        flatStackOnFloorWithinEntranceList = hFlat - dFlat + 1;
                        putListData(i, hFlat, dFlat, flatStackOnFloorWithinEntranceList);
                    } else {
                        flatStackOnFloorWithinEntranceList = hFlat - dFlt + 1;
                        putListData(i, hFlat, dFlt, flatStackOnFloorWithinEntranceList);
                    }

                    hFlat = hFlat - apartmentsOnFloor;

                    if (hFlat < dFlat) {
                        hFlat = 0;
                    }
                }
            }
        } else {
            listData();
        }
    }

    private void correctLUFlats() {
        if (isFlatNum() && floorsNum > 0) {
            hiFlat = floorsNum * 4;

            while (hiFlat < flatNum) {
                hiFlat = hiFlat + floorsNum * 4;
            }

            dwnFlat = (hiFlat - floorsNum * 4) + 1;
        }
    }

    private void correctApartmentsOnFloor(){
        do {
            if (howMuchFlatsOnEntranceReal() == howMuchFlatsOnEntranceCalculated()) {
                break;
            } else if ((howMuchFlatsOnEntranceReal() - howMuchFlatsOnEntranceCalculated()) > apartmentsOnFloor + 1) {
                //warning! first stage: num flats!!!
                apartmentsOnFloor++;
                break;
            } else if ((howMuchFlatsOnEntranceReal() - howMuchFlatsOnEntranceCalculated()) <= apartmentsOnFloor + 1) {
                //warning! Exception!!!
                apartmentsOnFloor++;
            }
        } while ((howMuchFlatsOnEntranceReal() == howMuchFlatsOnEntranceCalculated()) || ((howMuchFlatsOnEntranceReal() - howMuchFlatsOnEntranceCalculated()) > (apartmentsOnFloor + 1)));
    }

    private void setEntrance() {
        if (floorsNum > 0) {
            apartmentsOnFloor = howMuchFlatsOnEntranceReal() / floorsNum;
            entrance = (int) Math.round((double) hiFlat / howMuchFlatsOnEntranceReal());
        }
    }

    private void setStandardProcedure() {
        setEntrance();
        correctApartmentsOnFloor();
        setFlatStackNdListDataNdNecessaryFloor();
    }

}
