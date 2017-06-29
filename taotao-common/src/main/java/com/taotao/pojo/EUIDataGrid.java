package com.taotao.pojo;

import java.util.List;

/**
 * EasyUI DataGrid数据类型
 * Created by qiuhl on 2017/6/28.
 */
public class EUIDataGrid {
    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
