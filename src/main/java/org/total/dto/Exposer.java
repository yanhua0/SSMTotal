package org.total.dto;

public class Exposer {
    private String md5;
    private int id;
    private String name;
    private boolean exposed;

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exposer(String md5, int id, String name) {
        this.md5 = md5;
        this.id = id;
        this.name = name;
    }

    public Exposer(int id, boolean exposed) {
        this.id = id;
        this.exposed = exposed;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "md5='" + md5 + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
