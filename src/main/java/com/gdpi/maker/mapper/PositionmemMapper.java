package com.gdpi.maker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdpi.maker.pojo.Positionmem;
import com.gdpi.maker.pojo.PositionmemExample;

public interface PositionmemMapper {
    int countByExample(PositionmemExample example);

    int deleteByExample(PositionmemExample example);

    int insert(Positionmem record);

    int insertSelective(Positionmem record);

    List<Positionmem> selectByExample(PositionmemExample example);

    int updateByExampleSelective(@Param("record") Positionmem record, @Param("example") PositionmemExample example);

    int updateByExample(@Param("record") Positionmem record, @Param("example") PositionmemExample example);

    //<<<<<<<<<<<<<< 自己写的 >>>>>>>>>>>>>>>>>>>>>>
    Positionmem selectOnePositionmem(@Param("record")Positionmem record);
}