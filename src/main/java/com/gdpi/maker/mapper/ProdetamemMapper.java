package com.gdpi.maker.mapper;

import com.gdpi.maker.pojo.Prodetamem;
import com.gdpi.maker.pojo.ProdetamemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProdetamemMapper {
    int countByExample(ProdetamemExample example);

    int deleteByExample(ProdetamemExample example);

    int insert(Prodetamem record);

    int insertSelective(Prodetamem record);

    List<Prodetamem> selectByExample(ProdetamemExample example);

    int updateByExampleSelective(@Param("record") Prodetamem record, @Param("example") ProdetamemExample example);

    int updateByExample(@Param("record") Prodetamem record, @Param("example") ProdetamemExample example);

    //<<<<<<<<<<<<<<<<<<<< 自己写的 >>>>>>>>>>>>>>>>>>
    Prodetamem selectOneProdetamem(Prodetamem record);
}