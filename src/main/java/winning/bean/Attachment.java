package winning.bean;

import java.math.BigDecimal;

/**
 * Created by xwf on 2019/6/3.
 */
//附件
public class Attachment {

    private BigDecimal aId;
    private String aName;
    private String aFilePath;
    private String aUrl;

    public BigDecimal getaId() {
        return aId;
    }

    public void setaId(BigDecimal aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getaFilePath() {
        return aFilePath;
    }

    public void setaFilePath(String aFilePath) {
        this.aFilePath = aFilePath;
    }

    public String getaUrl() {
        return aUrl;
    }

    public void setaUrl(String aUrl) {
        this.aUrl = aUrl;
    }
}
