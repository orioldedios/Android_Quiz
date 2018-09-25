package com.elloiro.quiz;

public class PreguntaTest
{
private String text;
private  String[] respostes;
private int correct;

    public PreguntaTest(String text, String[] respostes, int correct) {
        this.text = text;
        this.respostes = respostes;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public String[] getRespostes() {
        return respostes;
    }

    public int getCorrect() {
        return correct;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRespostes(String[] respostes) {
        this.respostes = respostes;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }
}
