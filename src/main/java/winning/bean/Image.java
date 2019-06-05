package winning.bean;

import java.math.BigDecimal;

/**
 * Created by xwf on 2019/6/3.
 */
public class Image {

    private BigDecimal iId;
    private String iName;
    private String iFilePath;
    private String iUrl;

    public BigDecimal getiId() {
        return iId;
    }

    public void setiId(BigDecimal iId) {
        this.iId = iId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public String getiFilePath() {
        return iFilePath;
    }

    public void setiFilePath(String iFilePath) {
        this.iFilePath = iFilePath;
    }

    public String getiUrl() {
        return iUrl;
    }

    public void setiUrl(String iUrl) {
        this.iUrl = iUrl;
    }
}
