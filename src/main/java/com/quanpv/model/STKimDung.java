package com.quanpv.model;


public class STKimDung {

    private int id;
    private String deName;
    private String deContent;

    public STKimDung(int id, String deName, String deContent) {
        this.id = id;
        this.deName = deName;
        this.deContent = deContent;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeName() {
        return deName;
    }

    public void setDeName(String deName) {
        this.deName = deName;
    }

    public String getDeContent() {
        return deContent;
    }

    public void setDeContent(String deContent) {
        this.deContent = deContent;
    }

    @Override
    public String toString() {
        return "STKimDung{" +
                "id='" + id + '\'' +
                ", deName='" + deName + '\'' +
                ", deContent='" + deContent + '\'' +
                '}';
    }
}

