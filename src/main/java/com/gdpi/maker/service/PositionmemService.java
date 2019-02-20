package com.gdpi.maker.service;

import com.gdpi.maker.pojo.Positionmem;
import com.gdpi.maker.pojo.Result;

public interface PositionmemService {
    /**
     * 申请职位
     * @param positionId 职位Id
     * @param positionmemId 用户Id
     * @return
     */
    Result insertPositionmem(String positionId,String positionmemId);
    /**
     * 删除申请职位信息
     * @param positionmem
     * @return
     */
    Result deletePositionmem(Positionmem positionmem);
    /**
     * 修改申请职位信息
     * @param positionmem
     * @return
     */
    Result updatePositionmem(Positionmem positionmem);
    /**
     * 查询职位信息
     * @param positionmem
     * @param fenye
     * @return
     */
    Result selectPositionmem(Positionmem positionmem, Integer fenye,Integer pageSize);
    /**
     * 查询一个职位信息
     * @param position
     * @return
     */
//    Result selectPosition(Positionmem positionmem);
    /**
     * 根据Id查询
     * @param positionId
     * @return
     */
    //Result selectPositionById(String positionId);
}
