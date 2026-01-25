package com.hotcenplotz.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2026-01-25 20:36
 * @description: 员工分页查询封装类
 */

@Data
public class PageResult<T> {
    private long total;
    private List<T> rows;
    
    public PageResult() {
    }
    
    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
    
    public long getTotal() {
        return total;
    }
    
    public void setTotal(long total) {
        this.total = total;
    }
    
    public List<T> getRows() {
        return rows;
    }
    
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
