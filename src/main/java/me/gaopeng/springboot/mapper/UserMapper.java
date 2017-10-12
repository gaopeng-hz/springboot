package me.gaopeng.springboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by gaopeng on 2017/10/12.
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO account(name, money) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}
