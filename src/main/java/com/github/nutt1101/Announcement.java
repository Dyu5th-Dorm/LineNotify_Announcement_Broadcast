package com.github.nutt1101;

import com.github.nutt1101.data.AnnouncementFilter;
import com.github.nutt1101.data.DataScraper;
import com.github.nutt1101.model.AnnouncementModel;
import com.github.nutt1101.model.RequestionModel;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Announcement {
    static Class THIS = Announcement.class;

    static JSONObject data;
    static AnnouncementFilter filter;

    static Integer latest;

    public static void print(String message) {
        System.out.println(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + " : " +
                        message
        );
    }

    public static void main(String[] args) {
        while (true) {
            try {
                if (!Configuration.loaded) {
                    Configuration.init();

                }

                data = DataScraper.get(new RequestionModel("2700", 0, 1));

                filter = new AnnouncementFilter(data);

                AnnouncementModel latestAnn = filter.getAnnouncements().get(0);
                Integer currentID = latestAnn.getId();

                if (latest == null) {
                    latest = currentID;
                    LineNotify.sendMessage("最新公告抓取啟動。");
                    print("最新公告抓取啟動。");
                    continue;
                }

                if (latest < currentID) {
                    latest = currentID;
                    LineNotify.sendMessage(
                            "\n標題: " + latestAnn.getTitle() + "\n\n" +
                             latestAnn.getContent() + "\n\n" +
                            "連結: " + latestAnn.getURL() + "\n\n"
                    );
                    print("Updated!" + latestAnn.getTitle());
                } else {
                    print("now -> " + latestAnn.getTitle());
                }

                Thread.sleep(30000);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
