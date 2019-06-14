package org.total.entity;

public class Nk {
    public int id;
    public String zj;
    public String zjName;
    public String ids;

    public Nk(String zj, String zjName, String id) {
        this.zj = zj;
        this.zjName = zjName;
        this.ids = id;
    }

    public Nk() {

    }

    @Override
    public String toString() {
        return "Nk{" +
                "zj='" + zj + '\'' +
                ", zjName='" + zjName + '\'' +
                ", id='" + ids + '\'' +
                '}';
    }
}
