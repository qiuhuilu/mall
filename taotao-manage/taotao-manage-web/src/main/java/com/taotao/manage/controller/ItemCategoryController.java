package com.taotao.manage.controller;

import com.taotao.manage.service.ItemCategoryService;
import com.taotao.pojo.EUITreeNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by qiuhl on 2017/6/28.
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCategoryController {
    @Autowired
    private ItemCategoryService itemCategoryService;

    /**
     * 查询商品类目列表
     * @param parentid 父商品类目节点id
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EUITreeNode> getItemCategoryList(@RequestParam(value = "id", defaultValue = "0") long parentid){
        List<EUITreeNode> result = itemCategoryService.getCategoryList(parentid);
        return result;
    }
}
