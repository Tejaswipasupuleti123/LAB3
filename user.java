package com.example.lab2pc;

public class user {
    private int appointmentid;
    private String patientname;
    private String appointmentdate;
    private String doctor;

    public user(int appointmentid, String patientname, String appointmentdate, String doctor) {
        this.appointmentid = appointmentid;
        this.patientname = patientname;
        this.appointmentdate = appointmentdate;
        this.doctor = doctor;
    }

    public int getappointmentid() {
        return appointmentid;
    }

    public void setappointmentid(int memberid) {
        this.appointmentid = appointmentid;
    }

    public String getpatientname() {
        return patientname;
    }

    public void setpatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getappointmentdate() {
        return appointmentdate;
    }

    public void setappointmentdate(String appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    public String getdoctor() {
        return doctor;
    }

    public void setdoctor(String doctor) {
        this.doctor = doctor;
    }

    public int user(int appointmentid, String patientname, String appointmentdate, String doctor) {
        this.appointmentid = appointmentid;
        this.patientname = patientname;
        this.appointmentdate = appointmentdate;
        this.doctor = doctor;
        return appointmentid;
    }
}