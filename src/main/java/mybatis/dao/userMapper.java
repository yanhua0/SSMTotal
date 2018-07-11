package mybatis.dao;

import mybatis.entity.user;

public interface userMapper {
    int deleteByPrimaryKey(String username);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}