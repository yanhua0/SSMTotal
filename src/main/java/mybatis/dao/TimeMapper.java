package mybatis.dao;

import mybatis.entity.Time;

import java.util.List;

public interface TimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Time record);

    int insertSelective(Time record);

    Time selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Time record);

    int updateByPrimaryKey(Time record);
    List<Time> findAll();
}