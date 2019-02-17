package mybatis.entity;

public class Time {
    private Integer id;

    private String name;

    private String year;

    private String jiben;

    private String mark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getJiben() {
        return jiben;
    }

    public void setJiben(String jiben) {
        this.jiben = jiben == null ? null : jiben.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}