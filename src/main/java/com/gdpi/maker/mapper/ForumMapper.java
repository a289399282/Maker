package com.gdpi.maker.mapper;

import com.gdpi.maker.pojo.Forum;
import com.gdpi.maker.pojo.ForumExample;
import com.gdpi.maker.pojo.ForumWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ForumMapper {
    int countByExample(ForumExample example);

    int deleteByExample(ForumExample example);

    int deleteByPrimaryKey(String forumId);

    int insert(ForumWithBLOBs record);

    int insertSelective(ForumWithBLOBs record);

    List<ForumWithBLOBs> selectByExampleWithBLOBs(ForumExample example);

    List<Forum> selectByExample(ForumExample example);

    ForumWithBLOBs selectByPrimaryKey(String forumId);

    int updateByExampleSelective(@Param("record") ForumWithBLOBs record, @Param("example") ForumExample example);

    int updateByExampleWithBLOBs(@Param("record") ForumWithBLOBs record, @Param("example") ForumExample example);

    int updateByExample(@Param("record") Forum record, @Param("example") ForumExample example);

    int updateByPrimaryKeySelective(ForumWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ForumWithBLOBs record);

    int updateByPrimaryKey(Forum record);
    
  //<<<<<<<<<<<<<<<<<<<<<<<< 自己写的>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    ForumWithBLOBs selectOneForum(Forum record);
    
}