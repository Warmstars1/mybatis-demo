package lianxi.test;

import lianxi.mapper.BrandMapper;
import lianxi.pojo.Brand;
import lianxi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectById() throws IOException {
        //接收参数
        int id = 1;
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        //接收参数
        int status = 0;
        String companyName = "松鼠";
        String brandName = "松鼠";
        //处理参数

//        companyName="%" +"松鼠" +"%";
//         brandName="%" +"松鼠" +"%";
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
        /*
        Brand brand=new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/

        Map map = new HashMap();
        //map.put("status",status);
        map.put("companyName", companyName);
        //map.put("brandName",brandName);
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands=brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "魅族";
        String brandName = "魅族";
        String description = "真的喜欢";
        int ordered = 100;
        //处理参数

//        companyName="%" +"松鼠" +"%";
//         brandName="%" +"松鼠" +"%";
        //companyName="%" +companyName +"%";
        // brandName="%" +brandName +"%";

        //封装对象

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
//        Map map=new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands=brandMapper.selectByCondition(brand);
//        List<Brand> brands=brandMapper.selectByCondition(map);
        brandMapper.add(brand);
        //提交事务
        //sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "魅族";
        String brandName = "魅族";
        String description = "真的喜欢";
        int ordered = 100;
        //处理参数

//        companyName="%" +"松鼠" +"%";
//         brandName="%" +"松鼠" +"%";
        //companyName="%" +companyName +"%";
        // brandName="%" +brandName +"%";

        //封装对象

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
//        Map map=new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands=brandMapper.selectByCondition(brand);
//        List<Brand> brands=brandMapper.selectByCondition(map);
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        //提交事务
        //sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        //接收参数
        int status = 1;
        String companyName = "魅族";
        String brandName = "魅族";
        String description = "真的好用，真的喜欢";
        int ordered = 200;
        int id = 10;
        //处理参数

//        companyName="%" +"松鼠" +"%";
//         brandName="%" +"松鼠" +"%";
        //companyName="%" +companyName +"%";
        // brandName="%" +brandName +"%";

        //封装对象

        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);
//        Map map=new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        //List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //List<Brand> brands=brandMapper.selectByCondition(brand);
//        List<Brand> brands=brandMapper.selectByCondition(map);
        int count = brandMapper.update(brand);
        System.out.println(count);
        //提交事务
        //sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }
    @Test
    public void testDeleteById() throws IOException {
        //接收参数
        int id = 20;
        //处理参数

//        companyName="%" +"松鼠" +"%";
//         brandName="%" +"松鼠" +"%";
        //companyName="%" +companyName +"%";
        // brandName="%" +brandName +"%";
//        Map map=new HashMap();
//        map.put("status",status);
//        map.put("companyName",companyName);
        //map.put("brandName",brandName);
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        brandMapper.deleteById(id);
        //提交事务
        //sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }
    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数
        int[] ids={17,18,19};

        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //2.获取SqlSession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        brandMapper.deleteByIds(ids);
        //提交事务
        //sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

}
