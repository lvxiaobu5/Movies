package movies.bean;

import java.util.Date;

/**
 * TODO
 *
 * @author KaYo
 * @date 2019/12/3 - 0:59
 */
public class Party {
    public Party(){}
    public Party(long id,String username, String address, long perprice, String introduce, Date partydate,String phone) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.perprice = perprice;
        this.introduce = introduce;
        this.partydate = partydate;
        this.phone = phone;
    }

    private long id;

    private String username;

    private String address;

    private long perprice;

    private String introduce;

    private Date partydate;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPerprice() {
        return perprice;
    }

    public void setPerprice(long perprice) {
        this.perprice = perprice;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getPartydate() {
        return partydate;
    }

    public void setPartydate(Date partydate) {
        this.partydate = partydate;
    }
}
