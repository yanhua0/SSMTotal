package org.total.entity;

public class Nk {
    public String type;
    public String jc;
    public String zz;
    public String cbs;
    public int id;
    public String zj;
    public String zjName;
    public String ids;

    public Nk(String type, String jc, String zz, String cbs, String zj, String zjName, String ids) {
        this.type = type;
        this.jc = jc;
        this.zz = zz;
        this.cbs = cbs;
        this.zj = zj;
        this.zjName = zjName;
        this.ids = ids;
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
