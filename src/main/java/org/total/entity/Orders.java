package org.total.entity;
import java.util.Date;

public class Orders {
    private Integer id;

    private String snu;

    private Long price;

    private Date stime;
    private int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    /*
        多对1
         */
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSnu() {
        return snu;
    }

    public void setSnu(String snu) {
        this.snu = snu == null ? null : snu.trim();
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", snu='" + snu + '\'' +
                ", price=" + price +
                ", stime=" + stime +
                ", cid=" + cid +
                ", customer=" + customer +
                '}';
    }
}