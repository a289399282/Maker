package com.gdpi.maker.service.impl.userImpl;

import com.gdpi.maker.dao.DeveloperDao;
import com.gdpi.maker.dao.PositionDao;
import com.gdpi.maker.dao.PositionmemDao;
import com.gdpi.maker.dao.StudioDao;
import com.gdpi.maker.pojo.*;
import com.gdpi.maker.service.PositionmemService;
import com.gdpi.maker.utils.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("Duplicates")
@Service("PositionmemServiceImpl")
public class PositionmemServiceImpl implements PositionmemService {
    @Autowired
    private PositionmemDao positionmemDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private DeveloperDao developerDao;

    @Override
    public Result insertPositionmem(String positionId, String positionmemId) {
        if (positionId != null && positionmemId !=null) {
            Positionmem positionmem3=new Positionmem();
            positionmem3.setPositionmemId(positionmemId);
            positionmem3.setPositionId(positionId);
            //查看是否有记录,没有就让申请
            List<Positionmem> positionmems = positionmemDao.selectPositionmem(positionmem3);
            if (positionmems.size() != 0) {
                for (Positionmem positionmem2 : positionmems) {
                    if (positionmem2.getPositionmemState()==1){
                        return ResultUtil.error("你已经提交申请,请不要重复提交!");
                    }
                    if (positionmem2.getPositionmemState()==2){
                        return ResultUtil.error("你已经成功被录用!");
                    }
                }
            }

        //if (positionmem1 == null) {
            //判断职位发布人
            Position position = positionDao.selectPositionById(positionId);

            if (position.getPositionEndtime() != null) {
                //SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                boolean before = new Date().after(position.getPositionEndtime());
                if (before) {
                    return ResultUtil.error("职位申请时间已结束");
                }
            }

            if (!position.getPositionmemId().equals(positionmemId)){
                positionmem3.setPositionmenSum((positionmems.size()+1));
                int i = positionmemDao.insertPositionmem(positionmem3);
                if (i == 1) {
                    return ResultUtil.success(null,"申请成功");
                }
                return ResultUtil.error("申请失败");
            }
            return ResultUtil.error("自己发布的职位自己不能申请");
        }
        return ResultUtil.error("用户Id或职业Id不能为空");
        //}
       // return ResultUtil.error("你已提交申请,请不要重复提交");
    }

    @Override
    public Result deletePositionmem(Positionmem positionmem) {
        if (positionmem.getPositionmenSum() != 0) {
            Positionmem positionmem1 = positionmemDao.selectOnePositionmem(positionmem);
            Integer positionmemState = positionmem1.getPositionmemState();
            if (positionmemState!=4){
                if (positionmem1 != null && positionmemState != 2 && positionmemState != 1) {
                    int i = positionmemDao.updatePositionnem(positionmem);
                    if (i == 1) {
                        return ResultUtil.success(null,"修改成功");
                    }
                    return ResultUtil.error("修改失败");
                }
                return ResultUtil.error("请撤销申请或辞职后,再删除记录");
            }
            return ResultUtil.error("已删除,请不要重复点击");
        }
        return ResultUtil.error("标识码为空");

    }

    @Override
    public Result updatePositionmem(Positionmem positionmem) {
        if (positionmem.getPositionmenSum() != 0) {
            if (positionmem.getPositionmemId()!= null && positionmem.getPositionId() !=null) {
                //查询是否有记录
                Positionmem positionmem1=new Positionmem();
                positionmem1.setPositionId(positionmem.getPositionId());
                positionmem1.setPositionmemId(positionmem.getPositionmemId());
                Positionmem positionmem2 = positionmemDao.selectOnePositionmem(positionmem1);
                if (positionmem2 != null) {
                    //判断状态
                    if (positionmem.getPositionmemState() >=0 &&  positionmem.getPositionmemState() <3) {
                        if (!positionmem2.getPositionmemState().equals(positionmem.getPositionmemState())) {
                            //"2:成功"就设置日期
                            if (positionmem.getPositionmemState() == 2) {
                                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                                try {
                                    positionmem.setPositionmenReltime(date.parse(date.format(new Date())));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                            //"3:辞职"就设置日期
                            if (positionmem.getPositionmemState() == 3) {
                                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                                try {
                                    positionmem.setPositionmenEndime(date.parse(date.format(new Date())));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                            int i = positionmemDao.updatePositionnem(positionmem);
                            if (i == 1) {
                                return ResultUtil.success(null,"修改成功");
                            }
                            return ResultUtil.error("修改失败");
                        }
                        return ResultUtil.error("申请状态已是这种状态");
                    }
                    return ResultUtil.error("申请状态有误");
                }
                return ResultUtil.error("此记录不存在");
            }
            return ResultUtil.error("用户Id或职业Id不能为空");
        }
        return ResultUtil.error("标识码为空");
    }

    @Override
    public Result selectPositionmem(Positionmem positionmem, Integer fenye, Integer pageSize) {
        //分页
        PageHelper.startPage(fenye,pageSize);
        List<Positionmem> list = positionmemDao.selectPositionmem(positionmem);
        PageInfo pageInfo = new PageInfo<>(list);
        int size = pageInfo.getSize();
        if (size!=0) {
            //封装数据
            List<PositionmemCut> posmemCutlist =new ArrayList<PositionmemCut>();
            PositionmemCut positionmemCut;
            Positionmem positionmem1;

            try {
                List list1 = pageInfo.getList();
                for (int i = 0; i <size ; i++) {
                    positionmemCut=new PositionmemCut();
                    //position3 = new Position();
                    positionmem1 = (Positionmem) list1.get(i);
                    BeanUtils.copyProperties(positionmemCut, positionmem1);
                    //获取发布人Id
                    String positionmemId = positionmemCut.getPositionmemId();
                    //设置申请人名字
                    Developer developer = developerDao.selectDeveloperById(positionmemId);
                    positionmemCut.setPositionmemIdName(developer.getDevName());
                    //设置职位名称
                    Position position = positionDao.selectPositionById(positionmemCut.getPositionId());
                    positionmemCut.setPositionIdName(position.getPositionName());

                    posmemCutlist.add(positionmemCut);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return ResultUtil.success(posmemCutlist, "查询成功",pageInfo.getTotal());
        }
        return ResultUtil.success(null, "无数据");
    }
}
