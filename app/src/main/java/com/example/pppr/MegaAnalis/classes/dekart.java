package com.example.pppr.MegaAnalis.classes;

import java.util.List;

public class dekart {
    private List<String> silniestoronni;
    private List<String> slabiestoroni;
    private List<String> capabiliti;
    private List<String> threats;

    public List<String> getSilniestoronni() {
        return silniestoronni;
    }

    public void setSilniestoronni(List<String> silniestoronni) {
        this.silniestoronni = silniestoronni;
    }

    public List<String> getSlabiestoroni() {
        return slabiestoroni;
    }

    public void setSlabiestoroni(List<String> slabiestoroni) {
        this.slabiestoroni = slabiestoroni;
    }

    public List<String> getCapabiliti() {
        return capabiliti;
    }

    public void setCapabiliti(List<String> capabiliti) {
        this.capabiliti = capabiliti;
    }

    public List<String> getThreats() {
        return threats;
    }

    public void setThreats(List<String> threats) {
        this.threats = threats;
    }

    public dekart(List<String> list1, List<String> list2, List<String> list3, List<String> list4) {
        this.silniestoronni = list1;
        this.slabiestoroni = list2;
        this.capabiliti = list3;
        this.threats = list4;
    }
}
