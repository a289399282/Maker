package com.gdpi.maker.pojo;

import com.github.rjeschke.txtmark.Processor;

public class ForumWithBLOBs extends Forum {
    private String forumInfo;

    private String forumTextafter;

    private String forumText;

    private Integer OrderByClause;

    public Integer getOrderByClause() {
        return OrderByClause;
    }

    public void setOrderByClause(Integer orderByClause) {
        OrderByClause = orderByClause;
    }

    public String getForumInfo() {
        return forumInfo;
    }

    public void setForumInfo(String forumInfo) {
        this.forumInfo = forumInfo == null ? null : forumInfo.trim();
    }

    public String getForumTextafter() {
        return forumTextafter;
    }

    public void setForumTextafter(String forumTextafter) {
        this.forumTextafter = forumTextafter == null ? null : forumTextafter.trim();
    }

    public String getForumText() {
        return forumText;
    }

    public void setForumText(String forumText) {
        this.forumText = forumText == null ? null : forumText.trim();

        this.forumTextafter = Processor.process(forumText);
    }
}