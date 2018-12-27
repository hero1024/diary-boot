package com.spj.diary.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Page {
    private Long pageIndex;
    private Long pageSize;

    public Long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }
}
