package com.demospringcloud.eurekaclient.eurekaclient.mapper;

import com.demospringcloud.eurekaclient.eurekaclient.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}

