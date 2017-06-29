package com.taotao.manage.service;

import com.taotao.manage.mapper.ItemCatMapper;
import com.taotao.manage.pojo.ItemCat;
import com.taotao.pojo.EUITreeNode;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qiuhl on 2017/6/28.
 */
public interface ItemCategoryService {
    List<EUITreeNode> getCategoryList(long parentid);
}
