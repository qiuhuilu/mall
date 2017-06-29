package com.taotao.manage.service.impl;

import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;
import com.taotao.manage.pojo.ItemCatExample;
import com.taotao.manage.service.ItemCategoryService;
import com.taotao.pojo.EUITreeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiuhl on 2017/6/28.
 */
@Service
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    /**
     * 查询产品类目列表
     * @param parentid 父商品类目节点id
     * @return
     */
    @Override
    public List<EUITreeNode> getCategoryList(long parentid) {
        //Easy UI 节点列表
        List<EUITreeNode> result = new ArrayList<>();
        ItemCatExample example = new ItemCatExample();
        //创建查询条件
        ItemCatExample.Criteria criteria = example.createCriteria();
        //根据parentid查询
        criteria.andParentIdEqualTo(parentid);
        List<ItemCat> itemCatList = itemCatMapper.selectByExample(example);
        for(ItemCat itemCat : itemCatList){
            //节点
            EUITreeNode node = new EUITreeNode();
            node.setId(itemCat.getId());
            node.setText(itemCat.getName());
            //如果是父节点为“Closed” 叶子节点为“Open”
            node.setState(itemCat.getIsParent() ? "closed" : "open");
            result.add(node);
        }
        return result;
    }
}
