package org.total.dao;


import org.total.entity.Pro_ord;

public interface Pro_ordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pro_ord record);

    int insertSelective(Pro_ord record);

    Pro_ord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pro_ord record);

    int updateByPrimaryKey(Pro_ord record);
}