package mybatis.dao;

import mybatis.entity.Yiben;

import java.util.List;

public interface YibenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yiben record);

    int insertSelective(Yiben record);

    Yiben selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yiben record);

    int updateByPrimaryKey(Yiben record);
    List<String> findAll();
}