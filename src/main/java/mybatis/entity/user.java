package mybatis.entity;

import java.util.Date;

public class user {
    private String username;

    private String password;

    private Integer state;

    private String phone;

    private Date createTime;

    public user(String username, String password, Integer state, String phone, Date createTime) {
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