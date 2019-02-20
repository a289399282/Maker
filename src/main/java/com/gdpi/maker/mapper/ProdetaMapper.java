package com.gdpi.maker.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gdpi.maker.pojo.Prodeta;
import com.gdpi.maker.pojo.ProdetaExample;

public interface ProdetaMapper {
    int countByExample(ProdetaExample example);

    int deleteByExample(ProdetaExample example);

    int insert(Prodeta record);

    int insertSelective(Prodeta record);

    List<Prodeta> selectByExample(ProdetaExample example);

    int updateByExampleSelective(@Param("record") Prodeta record, @Param("example") ProdetaExample example);

    int updateByExample(@Param("record") Prodeta record, @Param("example") ProdetaExample example);

    //<<<<<<<<<<<<<<<<<<<<<<<< ×Ô¼ºÐ´µÄ >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    Prodeta selectOneProdeta(Prodeta record);
}