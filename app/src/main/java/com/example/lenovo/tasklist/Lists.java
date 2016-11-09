package com.example.lenovo.tasklist;

import java.util.ArrayList;

/**
 * Created by Lenovo on 11/5/2016.
 */

public class Lists {
    private String Title;
    private String Description;
    public static ArrayList<Lists> lists = new ArrayList<Lists>();

    public Lists(String Title,String Description) {
        this.Title=Title;
        this.Description=Description;
    }



    private static int lastContactId = 0;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public static void createContactsList(String atask,String adesc) {

        lists.add(new Lists(atask,adesc));
        }


    public static ArrayList<Lists> createList() {

        return lists;
    }

}