package com.qlzw.smartwc.utils;

public class Pager {

    private Integer page;
    private Integer size;

    public Pager() {}

    public Pager(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public String toString() {

        Integer page_start = (page-1)*size;
        Integer page_end = page*size;

        return " <Pager> { page=" + page + " size=" + size + "}";
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

