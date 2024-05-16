package com.example.pppr.MegaAnalis.classes;

import java.util.List;

public class zauprotiv {
    private List<String> spisokza;
    private List<String> spisokprotiv;

    public zauprotiv(List<String> spisokza, List<String> spisokprotiv) {
        this.spisokza = spisokza;
        this.spisokprotiv = spisokprotiv;
    }

    public List<String> getSpisokza() {
        return spisokza;
    }

    public void setSpisokza(List<String> spisokza) {
        this.spisokza = spisokza;
    }

    public List<String> getSpisokprotiv() {
        return spisokprotiv;
    }

    public void setSpisokprotiv(List<String> spisokprotiv) {
        this.spisokprotiv = spisokprotiv;
    }
}
