package org.total.enums;

public enum TotalEnum {
     ;
    private int state;
    private String stateinfo;

    public int getState() {
        return state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    TotalEnum(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }
    public static TotalEnum stateof(int index)
    {
        for (TotalEnum state:values())
        {
            if(state.getState()==index)
            {
                return state;
            }

        }
        return null;
    }
}
