package winning.bean;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by xwf on 2019/6/4.
 */
public class TUser {

    private BigDecimal userId;
    private String loginName;
    private String password;
    private String username;
    private Date createTime;
    private Date lastLoginTime;
    private int readAndWriteRight;

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getReadAndWriteRight() {
        return readAndWriteRight;
    }

    public void setReadAndWriteRight(int readAndWriteRight) {
        this.readAndWriteRight = readAndWriteRight;
    }
}
