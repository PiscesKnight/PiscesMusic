package com.example.lintai.musicradio.entity;

/**
 * Created by LinTai on 2016/9/4.
 */
public class MyMusicEntity {

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListImg() {
        return listImg;
    }

    public void setListImg(String listImg) {
        this.listImg = listImg;
    }

    public String getListContent() {
        return listContent;
    }

    public void setListContent(String listContent) {
        this.listContent = listContent;
    }

    private String listName;
    private String listImg;
    private String listContent;
}
