package org.total.enums;

public enum TotalEnums {
     ;
    private int state;
    private String stateinfo;

    public int getState() {
        return state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    TotalEnums(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }
    public static TotalEnums stateof(int index)
    {
        for (TotalEnums state:values())
        {
            if(state.getState()==index)
            {
                return state;
            }

        }
        return null;
    }
}
