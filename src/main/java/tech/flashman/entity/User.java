package tech.flashman.entity;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * 用户id
     */
    private Long userid;

    /**
     * 账户
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 生日
     */
    private Long brothday;

    /**
     * 性别
     */
    private String gender;

    /**
     * 注册时间
     */
    private Long rigesttime;

    /**
     * 修改时间
     */
    private Long modifytime;

    /**
     * 修改人
     */
    private String modifyuser;

    private static final long serialVersionUID = 1L;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Long getBrothday() {
        return brothday;
    }

    public void setBrothday(Long brothday) {
        this.brothday = brothday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Long getRigesttime() {
        return rigesttime;
    }

    public void setRigesttime(Long rigesttime) {
        this.rigesttime = rigesttime;
    }

    public Long getModifytime() {
        return modifytime;
    }

    public void setModifytime(Long modifytime) {
        this.modifytime = modifytime;
    }

    public String getModifyuser() {
        return modifyuser;
    }

    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser == null ? null : modifyuser.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", account=").append(account);
        sb.append(", password=").append(password);
        sb.append(", username=").append(username);
        sb.append(", brothday=").append(brothday);
        sb.append(", gender=").append(gender);
        sb.append(", rigesttime=").append(rigesttime);
        sb.append(", modifytime=").append(modifytime);
        sb.append(", modifyuser=").append(modifyuser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}