package com.example.lintai.musicradio.entity;

import java.util.List;

/**
 * Created by LinTai on 2016/9/1.
 */
public class RankingDB {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }



    private String title;
    private String logo;

    private List<Songs> songs;

    public List<Songs> getSongs() {
        return songs;
    }

    public void setSongs(List<Songs> songs) {
        this.songs = songs;
    }

    public static class Songs{
        private String songName;

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }
    }
}
