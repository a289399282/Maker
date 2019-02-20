package com.gdpi.maker.mapper;

import com.gdpi.maker.pojo.Developer;
import com.gdpi.maker.pojo.DeveloperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeveloperMapper {
    int countByExample(DeveloperExample example);

    int deleteByExample(DeveloperExample example);

    int deleteByPrimaryKey(String devId);

    int insert(Developer record);

    int insertSelective(Developer record);

    List<Developer> selectByExampleWithBLOBs(DeveloperExample example);

    List<Developer> selectByExample(DeveloperExample example);

    Developer selectByPrimaryKey(String devId);

    int updateByExampleSelective(@Param("record") Developer record, @Param("example") DeveloperExample example);

    int updateByExampleWithBLOBs(@Param("record") Developer record, @Param("example") DeveloperExample example);

    int updateByExample(@Param("record") Developer record, @Param("example") DeveloperExample example);

    int updateByPrimaryKeySelective(Developer record);

    int updateByPrimaryKeyWithBLOBs(Developer record);

    int updateByPrimaryKey(Developer record);
    
	//<<<<<<<<<<<<<<<<<<<<<<<<<<< 自己写的 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	Developer selectOneDeveloper(@Param("record") Developer record);
	
	Developer selectDevByIdExist(String devId);
}