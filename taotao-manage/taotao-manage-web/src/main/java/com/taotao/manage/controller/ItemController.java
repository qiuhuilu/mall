package com.taotao.manage.controller;

import com.taotao.manage.pojo.Item;
import com.taotao.manage.service.ItemService;
import com.taotao.pojo.EUIDataGrid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qiuhl on 2017/6/27.
 */
@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 根据商品ID查询商品
     * @param itemId 商品ID
     * @return
     */
    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public Item getItemById(@PathVariable Long itemId){
        Item item = itemService.getItemById(itemId);
        return item;
    }

    /**
     * 获取产品列表
     * @param page 页码
     * @param rows 每页显示数目
     * @return
     */
    @RequestMapping("/item/list")
    @ResponseBody
    public EUIDataGrid getItemList(int page, int rows){
        EUIDataGrid result = itemService.getItemList(page, rows);
        return result;
    }
}
