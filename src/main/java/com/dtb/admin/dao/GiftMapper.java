package com.dtb.admin.dao;

import com.dtb.entity.GiftWithBLOBs;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lmx
 * @version 1.0.0
 * @create 2019/4/4-21:57
 */
@Repository("giftAdminMapper")
public interface GiftMapper {

    /**
     * 根据id查询
     *
     * @param id 主键
     * @return com.dtb.entity.GiftWithBLOBs
     * @author lmx
     * @date 2019/4/4 21:58
     */
    GiftWithBLOBs selectById(@Param("id") Integer id);

    /**
     * 多条件分页查询
     *
     * @param queryParam 搜索参数
     * @return com.github.pagehelper.Page<com.dtb.entity.GiftWithBLOBs>
     * @author lmx
     * @date 2019/4/6 1:46
     */
    Page<GiftWithBLOBs> selectPageList(@Param("queryParam") GiftWithBLOBs queryParam);

    /**
     * 根据id批量修改
     *
     * @param idList idlist
     * @param param  参数
     * @return java.lang.Integer
     * @author lmx
     * @date 2019/4/6 2:03
     */
    Integer updateBatchByIds(@Param("idList") List<Integer> idList, @Param("param") GiftWithBLOBs param);

    /**
     * 添加
     *
     * @param param 参数
     * @return java.lang.Integer
     * @author lmx
     * @date 2019/4/6 2:11
     */
    Integer insert(@Param("param") GiftWithBLOBs param);

    /**
     * 根据id查找
     *
     * @param id id
     * @return com.dtb.entity.GiftWithBLOBs
     * @author lmx
     * @date 2019/4/6 2:14
     */
    GiftWithBLOBs findById(@Param("id") Integer id);
}
