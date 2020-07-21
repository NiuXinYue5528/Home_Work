package com.example.day08_mvp.bean;

public class EventBean {
    private int progress;
    private int max;

    public EventBean(int progress, int max) {
        this.progress = progress;
        this.max = max;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
