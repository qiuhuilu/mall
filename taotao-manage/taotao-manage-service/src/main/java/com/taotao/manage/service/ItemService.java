package com.taotao.manage.service;

import com.taotao.manage.pojo.Item;
import com.taotao.pojo.EUIDataGrid;

/**
 * Created by qiuhl on 2017/6/27.
 */
public interface ItemService {
    Item getItemById(long itemId);
    EUIDataGrid getItemList(int page, int rows);
}
