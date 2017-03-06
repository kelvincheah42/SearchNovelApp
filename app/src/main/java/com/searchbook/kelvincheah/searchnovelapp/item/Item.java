package com.searchbook.kelvincheah.searchnovelapp.item;


/**
 * Created by ASUS on 1/3/2017.
 */
// Constructor for variable
public class Item {
    int id;
    String BOOK_NAME;
    String AUTHOR;
    String DESCRIPTION;
    int cover;
    int[] img;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBOOK_NAME() {
        return BOOK_NAME;
    }

    public void setBOOK_NAME(String BOOK_NAME) {this.BOOK_NAME = BOOK_NAME;}

    public String getAUTHOR() {
        return AUTHOR;
    }

    public void setAUTHOR(String AUTHOR) {
        this.AUTHOR = AUTHOR;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getCover(){return cover;}

    public void setCover(int[] image){this.img=image;}




}

