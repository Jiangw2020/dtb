package com.dtb.home.service;

import com.dtb.entity.Address;

import java.util.List;

/**
 * 收货地址服务
 *
 * @author lmx
 * @date 2019/3/24 0:03
 */
public interface AddressService {

    /**
     * 根据用户id查询用户的收货地址列表
     *
     * @param userId 用户id
     * @return java.util.List<com.dtb.entity.Address>
     * @author lmx
     * @date 2019/3/24 0:04
     */
    List<Address> findAddressListByUserId(Integer userId);

    /**
     * @param id 根据id查询
     * @return com.dtb.entity.Address
     * @author lmx
     * @date 2019/3/24 16:02
     */
    Address findAddressById(Integer id);

    /**
     * 根据id修改
     *
     * @param param 参数
     * @return java.lang.Integer
     * @author lmx
     * @date 2019/4/6 16:02
     */
    Integer updateById(Address param);

    /**
     * 添加
     *
     * @param param 参数
     * @return java.lang.Integer
     * @author lmx
     * @date 2019/4/6 16:37
     */
    Integer add(Address param);
}
