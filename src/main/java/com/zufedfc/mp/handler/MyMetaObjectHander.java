package com.zufedfc.mp.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHander implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建自动填充created_at
        this.setFieldValByName("createdAt", new Date(), metaObject);
        // 创建自动填充updated_at
        this.setFieldValByName("updatedAt", new Date(), metaObject);
        // 创建自动填充version
        this.setFieldValByName("version", 1, metaObject);
        // 创建自动填充deleted
        this.setFieldValByName("deleted", 0, metaObject);


    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        更新updated_at
        this.setFieldValByName("updatedAt", new Date(), metaObject);

    }
}
