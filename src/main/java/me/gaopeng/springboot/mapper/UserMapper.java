package me.gaopeng.springboot.mapper;

import me.gaopeng.springboot.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * Created by gaopeng on 2017/10/12.
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO ACCOUNT(NAME, MONEY) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Insert("INSERT INTO ACCOUNT(NAME, MONEY) VALUES(#{name}, #{age})")
    int insertByMap(Map userInfo);

    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "money")
    })
    @Select("SELECT * FROM ACCOUNT WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

}
