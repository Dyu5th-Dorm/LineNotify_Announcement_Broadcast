package com.github.nutt1101.model;

import org.json.JSONObject;

import java.util.HashMap;

public class RequestionModel {
    String poolID;
    String sDate;
    String eDate;
    String sItems;
    String eItems;

    @Override
    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("pool_ID", poolID);
        hashMap.put("sitems", sItems);
        hashMap.put("eitems", eItems);
        return new JSONObject(hashMap).toString();
    }

    public RequestionModel(String poolID, int sItems, int eItems) {
        this.poolID = poolID;
        this.sItems = String.valueOf(sItems >= 0 ? sItems : 0);
        this.eItems = String.valueOf(eItems == 0 ? 1 : eItems);
    }

    public RequestionModel(String poolID, String sDate, String eDate, int sItems, int eItems) {
        this.poolID = poolID;
        this.sDate = sDate;
        this.eDate = eDate;
        this.sItems = String.valueOf(sItems);
        this.eItems = String.valueOf(eItems);
    }

    public RequestionModel(String poolID) {
        this.poolID = poolID;
        this.sItems = String.valueOf(0);
        this.eItems = String.valueOf(15);
    }
}
