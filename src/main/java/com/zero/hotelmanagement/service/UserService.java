package com.zero.hotelmanagement.service;

import com.zero.hotelmanagement.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    /**
     * 增加用户信息
     * @param user 用户对象
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int insertUser(User user);

    /**
     * 删除用户信息
     * @param userId 用户id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int deleteUser(@Param("userId")Integer userId);

    /**
     * 修改用户信息
     * @param user 用户id
     * @return 返回0表示失败 返回正整数表示数据库中受影响的条数
     */
    int updateUser(User user);

    /**
     * 根据用户编号查询用户信息
     * @param userId 用户id
     * @return 返回查询到的用户列表
     */
    List<User> selectUserById(@Param("userId")Integer userId);

    /**
     * 根据用户名查询用户信息
     * @param userName 用户id
     * @return 返回查询到的用户列表
     */
    List<User> selectUserByName(@Param("userName")String userName);

    /**
     * 分页查询所有用户信息
     * @param page 页数，一页显示六个
     * @return 分页查询用户列表
     */
    List<User> getUser(@Param("page") int page);

    /**
     * 计算用户总数
     * @return 用户总数
     */
    int countAllUsers();
}
