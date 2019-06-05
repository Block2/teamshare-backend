package winning.dao;

import winning.bean.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface ImageDao {


    Image getImageById(@Param("id") String id);
    int updateImage(Image image);

    int deleteImageById(@Param("id") String id);
    int insertImage(Image image);
    int insertBatchImage(List<Image> images);

}
