package lianxi.mapper;

import lianxi.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/*
        Mybatis 参数封装:
        *单个参数
        1.POJO类型：直接来使用，属性名 和 参数占位符名称一致
        2.Map集合：直接使用，键名和参数占位符名称一致
        3.Collection：封装为Map集合 可以使用@Param注解，替换Map集合中默认的ago键名
        map.put("age0",collection集合)；
        map.put("collection",collection集合)
        4.List：封装为Map集合 可以使用@Param注解，替换Map集合中默认的ago键名
        map.put("age0",collection集合)；
        map.put("collection",collection集合)
        map.put("List",List集合)
        5.Array：封装为Map集合 可以使用@Param注解，替换Map集合中默认的ago键名
        map.put("age0",数组)；
        map.put("array",数组)
        6.其他类型：直接使用
        *多个参数:封装为Map集合,可以使用@Param注解，替换Map集合中默认的ago键名
        map.put("arg0",参数值1)
        map.put("param1",参数值1)
        map.put("arg1",参数值2)
        map.put("param2",参数值2)

 */

public interface BrandMapper {
    //查询所有
    public List<Brand> selectAll();

    //查看详情
    Brand selectById(int id);
    /*条件查询
     *参数接收
     *     1.散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *     2.对象参数
     *     3.map集合参数
     */

    // List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    // 单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);

    //添加
    void add(Brand brand);

    //修改
    int update(Brand brand);

    //根据id删除
    void deleteById(int id);

    //批量删除
    void deleteByIds(@Param("ids") int[] ids);

}
