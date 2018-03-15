package org.total.dto;


import org.total.enums.TotalEnum;

public class Result {

    private int state;
    private String stateinfo;



    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    public void setStateinfo(String stateinfo) {
        this.stateinfo = stateinfo;
    }

    public Result(TotalEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateinfo = stateEnum.getStateinfo();
    }

}
