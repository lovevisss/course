package com.zufedfc.mp;

import com.zufedfc.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MpApplicationTests {
    @Autowired
    UserMapper userMapper;
    //查询User 表中的所有数据
    @Test
    void contextLoads() {
        System.out.println(userMapper.selectList(null));


    }

}
