package com.taotao.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manage.mapper.ItemMapper;
import com.taotao.manage.pojo.Item;
import com.taotao.manage.pojo.ItemExample;
import com.taotao.manage.service.ItemService;
import com.taotao.pojo.EUIDataGrid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qiuhl on 2017/6/27.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    /**
     * 根据商品ID查询商品详情
     * @param itemId 商品ID
     * @return
     */
    @Override
    public Item getItemById(long itemId) {

        return itemMapper.selectByPrimaryKey(itemId);
    }

    /**
     * 产品列表
     * @param page 页码
     * @param rows 每页显示数量
     * @return
     */
    @Override
    public EUIDataGrid getItemList(int page, int rows) {
        //EasyUI DataGrid数据
        EUIDataGrid result = new EUIDataGrid();
        ItemExample example = new ItemExample();
        //分页插件
        PageHelper.startPage(page, rows);
        //查询产品列表
        List<Item> items = itemMapper.selectByExample(example);
        result.setRows(items);
        //查询产品列表的总数
        PageInfo<Item> pageInfo = new PageInfo<>(items);
        result.setTotal((int) pageInfo.getTotal());
        //返回EUIDataGrid数据
        return result;
    }
}
