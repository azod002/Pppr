package com.example.pppr.MegaAnalis.classes;

import java.util.List;

public class tens {
    private List<String> days;
    private List<String> weeks;
    private List<String> mounth;

    public tens(List<String> days, List<String> weeks, List<String> mounth) {
        this.days = days;
        this.weeks = weeks;
        this.mounth = mounth;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public List<String> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<String> weeks) {
        this.weeks = weeks;
    }

    public List<String> getMounth() {
        return mounth;
    }

    public void setMounth(List<String> mounth) {
        this.mounth = mounth;
    }
}
