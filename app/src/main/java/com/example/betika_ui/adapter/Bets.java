package com.example.betika_ui.adapter;

public class Bets {
    private String one,two,title,title2,title3,button1,button2,button3,button4;

    public String getButton1() {
        return button1;
    }

    public void setButton1(String button1) {
        this.button1 = button1;
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getButton2() {
        return button2;
    }

    public void setButton2(String button2) {
        this.button2 = button2;
    }

    public String getButton3() {
        return button3;
    }

    public void setButton3(String button3) {
        this.button3 = button3;
    }

    public String getButton4() {
        return button4;
    }

    public void setButton4(String button4) {
        this.button4 = button4;
    }

    public Bets(String button1, String one, String two,
                String title, String title2, String title3,
                String button2, String button3, String button4)
    {
         this.button1 = button1;
         this.button2 = button2;
         this.button3 = button3;
        this.button4 = button4;
        this.one = one;
        this.two = two;
        this.title = title;
        this.title2 = title2;
        this.title3 = title3;


    }
}
