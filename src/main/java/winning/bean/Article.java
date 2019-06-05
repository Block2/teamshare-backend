package winning.bean;

import java.math.BigDecimal;

/**
 * Created by xwf on 2019/6/3.
 */

//文章
public class Article {

    private BigDecimal aId;
    private String title;
    private String tag;               //文章标签
    private String author;
    private String acomment;
    private String createTime;
    private byte[] bodypart;              //文章正文

    private String images;            //文章引用图片id  -  数组在数据库中以“;”隔开
    private String attachments;       //文章引用附件id  -  数组在数据库中以“;”隔开
    private BigDecimal mcId;                //对应栏目id

    public BigDecimal getaId() {
        return aId;
    }

    public void setaId(BigDecimal aId) {
        this.aId = aId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAcomment() {
        return acomment;
    }

    public void setAcomment(String acomment) {
        this.acomment = acomment;
    }

    public BigDecimal getMcId() {
        return mcId;
    }

    public void setMcId(BigDecimal mcId) {
        this.mcId = mcId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public byte[] getBodypart() {
        return bodypart;
    }

    public void setBodypart(byte[] bodypart) {
        this.bodypart = bodypart;
    }
}
