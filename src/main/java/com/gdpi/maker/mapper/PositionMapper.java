package com.gdpi.maker.mapper;

import com.gdpi.maker.pojo.Position;
import com.gdpi.maker.pojo.PositionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PositionMapper {
    int countByExample(PositionExample example);

    int deleteByExample(PositionExample example);

    int deleteByPrimaryKey(String positionId);

    int insert(Position record);

    int insertSelective(Position record);

    List<Position> selectByExampleWithBLOBs(PositionExample example);

    List<Position> selectByExample(PositionExample example);

    Position selectByPrimaryKey(String positionId);

    int updateByExampleSelective(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExampleWithBLOBs(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByExample(@Param("record") Position record, @Param("example") PositionExample example);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKeyWithBLOBs(Position record);

    int updateByPrimaryKey(Position record);

    //<<<<<<<<<<<<<<<<<<< 自己写的 >>>>>>>>>>>>>>>>>>>>>>
	Position selectOnePosition(Position position);

	Position selectPosByIdExist(String positionId);
}