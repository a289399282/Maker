package com.gdpi.maker.mapper;

import com.gdpi.maker.pojo.Studiomem;
import com.gdpi.maker.pojo.StudiomemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudiomemMapper {
    int countByExample(StudiomemExample example);

    int deleteByExample(StudiomemExample example);

    int insert(Studiomem record);

    int insertSelective(Studiomem record);

    List<Studiomem> selectByExample(StudiomemExample example);

    int updateByExampleSelective(@Param("record") Studiomem record, @Param("example") StudiomemExample example);

    int updateByExample(@Param("record") Studiomem record, @Param("example") StudiomemExample example);

    //<<<<<<<<<<<<<<<<< 自己写的 >>>>>>>>>>>>>>>>>>>
    Studiomem selectOneStudiomem(@Param("record") Studiomem record);
}