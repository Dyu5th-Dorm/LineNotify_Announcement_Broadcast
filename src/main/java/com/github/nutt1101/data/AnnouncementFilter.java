package com.github.nutt1101.data;

import com.github.nutt1101.model.AnnouncementModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementFilter {
    private JSONObject sourceData;
    private List<AnnouncementModel> announcements;

    public AnnouncementFilter(JSONObject sourceData) throws JSONException {
        this.sourceData = sourceData;
        this.announcements = new ArrayList<>();
        updateList();
    }

    public List<AnnouncementModel> getAnnouncements() {
        return announcements;
    }

    private void updateList() throws JSONException {
        JSONArray array = sourceData.getJSONArray("news");
        for (int i = 0; i < array.length(); i++) {
            var current = array.getJSONObject(i);
            announcements.add(
                    new AnnouncementModel(
                            Integer.valueOf(current.getString("msg_ID")),
                            current.getString("newstitle"),
                            current.getString("newcontent"),
                            current.getString("newsdate"),
                            current.getString("newsurl"),
                            current.getString("img")
                    )
            );
        }
    }
}
