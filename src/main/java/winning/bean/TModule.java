package winning.bean;

/**
 * Created by xwf on 2019/6/3.
 */

//顶级模块  top moudle
public class TModule {

    private String tmId;            //模块id
    private String tmName;          //模块名称
    private String tmComment;       //模块简介
    private Short idx;             //模块位置

    public String getTmId() {
        return tmId;
    }

    public void setTmId(String tmId) {
        this.tmId = tmId;
    }

    public String getTmName() {
        return tmName;
    }

    public void setTmName(String tmName) {
        this.tmName = tmName;
    }

    public String getTmComment() {
        return tmComment;
    }

    public void setTmComment(String tmComment) {
        this.tmComment = tmComment;
    }

    public Short getIdx() {
        return idx;
    }

    public void setIdx(Short idx) {
        this.idx = idx;
    }
}
