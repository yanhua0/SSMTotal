package org.total.entity;

import java.util.List;

/**
 * 分页实现
 *
 * @param <T>
 */

public class PageInfo<T> {
    private int page;//第几页
    private int pageSize;//每页显示信息数量
    private int totalCount;//总共有几条
    private int totalPage;//总共的页数
    private int start;//分页查询limit后的start
    private int end;//分页查询结束limit后的end
    public static int size = 5;//每页固定显示的信息数量
    private int maxId;
    private List<T> list;//每页显示数据

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public PageInfo(int page, int pageSize, int totalCount) {
        double t = totalCount;
        Double num = Math.ceil(t / pageSize);//计算总页数
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = num.intValue();
        this.start = (page - 1) * pageSize;//计算从第几条开始查
        this.end = pageSize;//计算从查到第几条
        this.maxId=totalPage*pageSize-pageSize*(page-1);
    }

    public PageInfo(int page, int pageSize, int totalCount, int totalPage) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;

    }

    public PageInfo() {

    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", start=" + start +
                ", end=" + end +
                ", maxId=" + maxId +
                ", list=" + list +
                '}';
    }
}
