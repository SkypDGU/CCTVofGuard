package com.skyp.cctvofguard;

public class cctvData {
    public cctvData(String cctvTitle, String cctvLink) {
        this.cctvTitle = cctvTitle;
        this.cctvLink = cctvLink;
    }

    public String getCctvTitle() {
        return cctvTitle;
    }

    public void setCctvTitle(String cctvTitle) {
        this.cctvTitle = cctvTitle;
    }

    public String getCctvLink() {
        return cctvLink;
    }

    public void setCctvLink(String cctvLink) {
        this.cctvLink = cctvLink;
    }

    String cctvTitle;
    String cctvLink;
}
