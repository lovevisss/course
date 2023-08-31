package com.zufedfc.mp;

import com.zufedfc.mp.entity.User;
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

//    添加操作
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("zufedfc");
        user.setEmail("530822987@qq.com");
        user.setPassword("123");
        int insert = userMapper.insert(user);
        System.out.println("insert: " + insert);
    }

//    修改操作
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(150L);
        user.setName("zufedfc");
        user.setEmail("test2@gmail.com");
        int row = userMapper.updateById(user);
        System.out.println("update: " + row);

    }
}
