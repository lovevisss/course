package com.zufedfc.mp;

import com.zufedfc.mp.entity.User;
import com.zufedfc.mp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        user.setAge(18);
        user.setEmail("530822987@qq.com");
        user.setPassword("123");
        int insert = userMapper.insert(user);
        System.out.println("insert: " + insert);
    }

//    修改操作
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1L);
        user.setName("zufedfc");
        user.setEmail("test2@gmail.com");
        int row = userMapper.updateById(user);
        System.out.println("update: " + row);

    }

    @Test
    public void testOptimisticUpdate() {
        User user = userMapper.selectById(1L);
        user.setName("zufedfc3");
        user.setEmail("test2@gmail.com4");
        int row = userMapper.updateById(user);
        System.out.println("update: " + row);

    }

    @Test
    public void testMAp(){


        Map<String, Object> sqlmap = new HashMap<>();
        String key_string = "";
        String value_string = "";
        String table_name = "HR_PERSON";
        // sql prefix using table_name
        String sql_prefix = "replace into " + table_name + "(";
        String sql_suffix = ") values(";
        String sql_end = ")";
        String full_sql = "";
//        这里一一对应key value
        sqlmap.put("PERSONID", 2);
        sqlmap.put("CORPID", 101);
        sqlmap.put("CORPCODE", "浙江嘉兴国有资本投资运营有限公司(本部)");
        sqlmap.put("CORPNAME", "浙江嘉兴国有资本投资运营有限公司(本部)");
        sqlmap.put("CORPCODE_GZ", "嘉兴国投2");
        sqlmap.put("CORPNAME_GZ", "嘉兴国投2");
        sqlmap.put("PERSONKIND", "人事代理");
        sqlmap.put("BILLID", "1");
        sqlmap.put("NAME", "test");
        sqlmap.put("CARDID", "23");
        sqlmap.put("SEX", "男");
        sqlmap.put("BIRTHDAY", "2020-01-01");
        sqlmap.put("IDENTITYID", "330326");
        sqlmap.put("SERVICESTATUS_MODEL", "在职");
        sqlmap.put("SERVICESTATUS_NAME", "在职");
        sqlmap.put("SERVICESTATUS_CODE", "1");
        sqlmap.put("ROLE_NAME", "张三");
        sqlmap.put("ROLE_CODE", "1");
        sqlmap.put("ROLE_ID", "3");
        sqlmap.put("DEPT_NAME", "人事部");
        sqlmap.put("DEPT_CODE", "1");
        sqlmap.put("DEPT_ID", "3");
//        遍历sqlmap
        for (Map.Entry<String, Object> entry : sqlmap.entrySet()) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());


//            判断是否最后一个元素

                key_string = key_string + entry.getKey() + ",";
                value_string = value_string + "'" + entry.getValue() + "',";

        }
        //remove last comma
        key_string = key_string.substring(0, key_string.length() - 1);
        value_string = value_string.substring(0, value_string.length() - 1);
//        System.out.println("key_string: " + key_string);
//        System.out.println("value_string: " + value_string);
        full_sql = sql_prefix + key_string + sql_suffix + value_string + sql_end;

//        System.out.println(full_sql);


    }


}
