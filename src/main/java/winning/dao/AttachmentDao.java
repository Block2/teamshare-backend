package winning.dao;

import winning.bean.Attachment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface AttachmentDao {

    List<Attachment> getAttachmentByAid(@Param("aid") String aid);
    int updateAttachmentById(Attachment attachment);

    int deleteAttachmentById(@Param("id") String id);
    int insertAttachment(Attachment attachment);
    int insertBatchAttachment(List<Attachment> attachments);
}
