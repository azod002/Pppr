package com.example.pppr.MegaAnalis.classes;

import java.util.List;

public class mpk {
    private List<String> mechtatel;
    private List<String> realist;
    private List<String> kritik;

    public mpk(List<String> mechtatel, List<String> realist, List<String> kritik) {
        this.mechtatel = mechtatel;
        this.realist = realist;
        this.kritik = kritik;
    }

    public List<String> getMechtatel() {
        return mechtatel;
    }

    public void setMechtatel(List<String> mechtatel) {
        this.mechtatel = mechtatel;
    }

    public List<String> getRealist() {
        return realist;
    }

    public void setRealist(List<String> realist) {
        this.realist = realist;
    }

    public List<String> getKritik() {
        return kritik;
    }

    public void setKritik(List<String> kritik) {
        this.kritik = kritik;
    }
}
