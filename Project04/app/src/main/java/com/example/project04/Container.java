package com.example.project04;

public class Container {
    private String name,phn, yourlocation, yourcity, yourstate, yourzipcode,destlocation, destcity, deststate, destzipcode, date, time,documentId;

    public Container(String documentId, String name, String phn, String yourlocation, String yourcity, String yourstate, String yourzipcode, String destlocation, String destcity, String deststate, String destzipcode, String date, String time) {
        this.documentId=documentId;
        this.name = name;
        this.phn = phn;
        this.yourlocation = yourlocation;
        this.yourcity = yourcity;
        this.yourstate = yourstate;
        this.yourzipcode = yourzipcode;
        this.destlocation = destlocation;
        this.destcity = destcity;
        this.deststate = deststate;
        this.destzipcode = destzipcode;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getPhn() {
        return phn;
    }

    public String getYourlocation() {
        return yourlocation;
    }

    public String getYourcity() {
        return yourcity;
    }

    public String getYourstate() {
        return yourstate;
    }

    public String getYourzipcode() {
        return yourzipcode;
    }

    public String getDestlocation() {
        return destlocation;
    }

    public String getDestcity() {
        return destcity;
    }

    public String getDeststate() {
        return deststate;
    }

    public String getDestzipcode() {
        return destzipcode;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDocumentId() {
        return documentId;
    }
}
