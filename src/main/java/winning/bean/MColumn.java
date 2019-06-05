package winning.bean;

import java.math.BigDecimal;

/**
 * Created by xwf on 2019/6/3.
 */

//栏目
public class MColumn {

    private BigDecimal mcId;        //栏目id
    private String mcName;      //栏目名称
    private String mcComment;   //栏目备注
    private BigDecimal tmId;        //所属模块id


    public BigDecimal getMcId() {
        return mcId;
    }

    public void setMcId(BigDecimal mcId) {
        this.mcId = mcId;
    }

    public String getMcName() {
        return mcName;
    }

    public void setMcName(String mcName) {
        this.mcName = mcName;
    }

    public String getMcComment() {
        return mcComment;
    }

    public void setMcComment(String mcComment) {
        this.mcComment = mcComment;
    }

    public BigDecimal getTmId() {
        return tmId;
    }

    public void setTmId(BigDecimal tmId) {
        this.tmId = tmId;
    }
}
