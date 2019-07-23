package com.zyq.mapper;

import com.zyq.bean.UserDemo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户接口
 *
 * @author admin
 * @date 2019-06-03 18:17
 */
public interface UserDemoMapper {

    /**
     * 添加方法
     * @param userDemo 保存的对象
     * @return 受影响的行数
     */
    int save(UserDemo userDemo);

    /**
     * 修改方法
     * @param userDemo 学生的类
     * @return 返回修改是否完成
     */
    int update(UserDemo userDemo);

    /**
     * 删除方法
     * @param id 学生的id
     * @return 删除方法是否完成
     */
    int delete(int id);


    /**
     * 查询学生信息的方法
     * @return 返回集合学生信息
     */
    List<UserDemo> queryStudent();

    /**
     * 模糊查询学生信息
     * @param userDemo 学生对象
     * @return 返回集合学生信息
     */
    List<UserDemo> queryStudentS(UserDemo userDemo);
}
