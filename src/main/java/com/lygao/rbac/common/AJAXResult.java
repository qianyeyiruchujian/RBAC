package com.lygao.rbac.common;

import com.github.pagehelper.PageInfo;

/**
 * @author lygao
 * @create 2020-02-13 20:37
 * 处理ajax类型返回值
 */
    public class AJAXResult<T> {
    private boolean success;
    private PageInfo<T> pageInfo;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public PageInfo<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<T> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
