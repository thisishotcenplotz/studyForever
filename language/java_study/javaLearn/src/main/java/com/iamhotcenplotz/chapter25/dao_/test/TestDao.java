package com.iamhotcenplotz.chapter25.dao_.test;


import com.iamhotcenplotz.chapter25.dao_.bean.Actor;
import com.iamhotcenplotz.chapter25.dao_.dao.daos.ActorDao;
import com.iamhotcenplotz.chapter25.dao_.utils.ConnectionPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author: Der Hotcenplotz
 * @version： 1.0
 * @date: 2025-04-29 10:46
 * @description:
 */


public class TestDao {

    @Test
    public void testActorDao() throws Exception {
        ActorDao actorDao = new ActorDao();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Actor> actors = actorDao.queryList("select * from demo.actor where id > ?", Actor.class, 1);

        for (Actor actor : actors) {
            System.out.println(actor);
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(actorDao.query("select * from demo.actor where id = ?", Actor.class, 2));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(actorDao.queryValue("select name from demo.actor where id = ?", 5));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(actorDao.update("insert into demo.actor values (null,'赵敏','女','1360-01-01',?)", 123456));
    }
}
