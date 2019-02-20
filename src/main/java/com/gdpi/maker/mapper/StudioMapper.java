package com.gdpi.maker.mapper;

import com.gdpi.maker.pojo.Studio;
import com.gdpi.maker.pojo.StudioExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudioMapper {
    int countByExample(StudioExample example);

    int deleteByExample(StudioExample example);

    int deleteByPrimaryKey(String stuId);

    int insert(Studio record);

    int insertSelective(Studio record);

    List<Studio> selectByExampleWithBLOBs(StudioExample example);

    List<Studio> selectByExample(StudioExample example);

    Studio selectByPrimaryKey(String stuId);

    int updateByExampleSelective(@Param("record") Studio record, @Param("example") StudioExample example);

    int updateByExampleWithBLOBs(@Param("record") Studio record, @Param("example") StudioExample example);

    int updateByExample(@Param("record") Studio record, @Param("example") StudioExample example);

    int updateByPrimaryKeySelective(Studio record);

    int updateByPrimaryKeyWithBLOBs(Studio record);

    int updateByPrimaryKey(Studio record);
    
    //<<<<<<<<<<<<<<<<<<<<< 自己写的 >>>>>>>>>>>>>>>>>>>>>
    Studio selectStuByIdExist(String stuId);
    
    Studio selectOneStudio(@Param("record") Studio record);
}