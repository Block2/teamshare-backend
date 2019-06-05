package winning.dao;

import winning.bean.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xwf on 2019/6/3.
 */
@Mapper
public interface TUserDao {

  TUser getUserByLoginName(@Param("loginName") String loginName);

}
