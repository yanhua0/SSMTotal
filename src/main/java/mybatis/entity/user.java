package mybatis.entity;

import java.util.Date;

public class User {
    private String username;

    private String password;

    private Integer state;

    private String phone;

    private Date createTime;

    public User(String username, String password, Integer state, String phone, Date createTime) {
        this.username = username;
        this.password = password;
        this.state = state;
        this.phone = phone;
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public Date getCreateTime() {
        return createTime;
    }
}