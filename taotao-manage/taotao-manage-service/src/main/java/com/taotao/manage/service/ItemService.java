package com.taotao.manage.service;

import com.taotao.manage.pojo.Item;
import com.taotao.pojo.EUIDataGrid;
import com.taotao.pojo.TaoTaoResult;

/**
 * Created by qiuhl on 2017/6/27.
 */
public interface ItemService {
    Item getItemById(long itemId);
    EUIDataGrid getItemList(int page, int rows);
    TaoTaoResult saveItem(Item item);
}
