package com.dtb.home.dao;

import com.dtb.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * @author lmx
     * @descript 根据手机号和密码登录
     * @date 2019/2/28 22:52
     * @param phone 手机号码
     * @return com.dtb.entity.User
     */
    User selectByPhone(@Param("phone") String phone);

    /**
     * @author lmx
     * @date 2019/3/1 18:33
     * @descript 根据邮箱查询用户
     * @param email 邮箱地址
     * @return com.dtb.entity.User
     */
    User selectByEmail(@Param("email") String email);

    /**
     * @author lmx
     * @date 2019/3/2 17:32
     * @descript 根据id查询用户信息
     * @param id 用户主键
     * @return int
     */
    int deleteByPrimaryKey(@Param("id") Integer id);

    /**
     * @author lmx
     * @date 2019/3/10 1:46
     * @descript 获取用户列表
     * @param
     * @return java.util.List<com.dtb.entity.User>
     */
    @Select("select id,user_name,nick_name from as_user where email_verify=true and delete_time is null")
    List<User> selectUserList();

    /**
     * @author lmx
     * @date 2019/3/10 22:51
     * @descript 根据用户类别分页查询用户列表
     * @param userType
     * @return com.github.pagehelper.Page<com.dtb.entity.User>
     */
    @Select("select id,user_name,nick_name,sex,province,city,area,user_type,email,user_photo,phone,user_summary,integral,create_time " +
            "from as_user " +
            "where user_type = #{userType} " +
            "and email_verify = true " +
            "and delete_time is null " +
            "order by integral DESC")
    Page<User> selectUserListToLimit(@Param("userType") Byte userType);

    /**
     * @author lmx
     * @date 2019/3/15 1:10
     * @descript 根据用户id修改积分值
     * @param integral 调整的积分（增加/减少）
     * @param userId 用户id
     * @return int
     */
    @Update("update as_user set integral = integral + #{integral} where id = #{userId}")
    int updateIntegralById(@Param("integral")Integer integral,@Param("userId")Integer userId);

    /**
     * @author lmx
     * @date 2019/3/16 17:07
     * @descript 查询用户基本信息及其答题统计信息
     * @param userId
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> selectUserInfoById(@Param("userId")Integer userId);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(User record);
}