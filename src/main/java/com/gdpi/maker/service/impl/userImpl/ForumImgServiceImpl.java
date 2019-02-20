package com.gdpi.maker.service.impl.userImpl;

import com.gdpi.maker.dao.ForumImgDao;
import com.gdpi.maker.pojo.Forumimg;
import com.gdpi.maker.pojo.Result;
import com.gdpi.maker.service.ForumImgService;
import com.gdpi.maker.utils.ResultUtil;
import com.gdpi.maker.utilsmy.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ForumImgServiceImpl")
public class ForumImgServiceImpl implements ForumImgService {
    @Autowired
    private ForumImgDao forumImgDao;

    @Override
    public Result insertForumimg(Forumimg forumimg) {
        String s="";
        Forumimg forumimg1;
        do {
            s= StringUtils.forumImgString();
            forumimg1 = forumImgDao.selectForumimgById(s);
        }while (forumimg1!=null);
        forumimg.setImgId(s);
        int i = forumImgDao.insertForumimg(forumimg);
        if (i == 1) {
            return ResultUtil.success(null,"添加成功");
        }
        return ResultUtil.error("添加失败");
    }

    @Override
    public Result deleteForumimg(String forumimgId) {
        return null;
    }

    @Override
    public Result updateForumimg(Forumimg forumimg) {
        return null;
    }

    @Override
    public Result selectForumimg(Forumimg forumimg) {
        return null;
    }
}
