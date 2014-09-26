/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wot_replay_filter;

import java.util.Date;

/**
 *
 * @author Timbo
 */
public class Replay {
    
    private Date date;
    private int time;
    private String nation;
    private String tank;
    private int decNumber;
    private String map;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getTank() {
        return tank;
    }

    public void setTank(String tank) {
        this.tank = tank;
    }

    public int getDecNumber() {
        return decNumber;
    }

    public void setDecNumber(int decNumber) {
        this.decNumber = decNumber;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
