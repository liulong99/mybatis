/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 需要视频资料或者咨询课程的可以加若曦老师的QQ：2408349392
 * author：鲁班学院-商鞅老师
 */
public class Test {

  public static void main(String[] args) throws Exception {
    String resource = "mybatis.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    SqlSession sqlSession1 = sqlSessionFactory.openSession();
    //从调用者角度来讲 与数据库打交道的对象 SqlSession

    //通过动态代理 去帮我们执行SQL
    DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);//返回动态代理后的mappwe
    DemoMapper mapper1 = sqlSession1.getMapper(DemoMapper.class);
    Map<String,Object> map = new HashMap<>();
    map.put("id","1");

    //因为一级缓存，这里不会调用两次SQL
    System.out.println(mapper.selectAll(map));
    System.out.println(mapper.selectAll(map));

    //因为有二级缓存，虽然是不同的Sql但是是在一个namespace中，因此不会调用两次SQL
    System.out.println(mapper1.selectAll(map));

    sqlSession.close();
    sqlSession1.close();
  }
}
