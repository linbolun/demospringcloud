package com.testspringcloudeurekafeginclient.eurekafeginclient.mapper;

import com.testspringcloudeurekafeginclient.eurekafeginclient.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Insert(" insert into user (id, name, age,\n" +
            "      gender, birthday, insert_time\n" +
            "      )\n" +
            "    values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER},\n" +
            "      #{gender,jdbcType=INTEGER}, #{birthday,jdbcType=VARCHAR}, #{insertTime,jdbcType=TIMESTAMP}\n" +
            "      )")
    int insertUser(User user);

    @Select(
            "select * from user"
    )
    List<User> listUserAll();
}
