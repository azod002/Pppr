package com.example.pppr.MegaAnalis.classes;

import java.util.List;

public class swot {
    private List<String> silniestoronni;
    private List<String> slabiestoroni;
    private List<String> capabiliti;
    private List<String> threats;

    public swot(List<String> silniestoronni, List<String> slabiestoroni, List<String> capabiliti, List<String> threats) {
        this.silniestoronni = silniestoronni;
        this.slabiestoroni = slabiestoroni;
        this.capabiliti = capabiliti;
        this.threats = threats;
    }

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



}
