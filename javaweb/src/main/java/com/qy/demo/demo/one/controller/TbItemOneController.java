package com.qy.demo.demo.one.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qy.demo.demo.one.entity.TbItemOne;
import com.qy.demo.demo.one.mapper.TbItemOneMapper;
import com.qy.demo.demo.one.service.ITbItemOneService;
import com.qy.demo.demo.one.utils.Result;
import com.qy.demo.demo.one.utils.ResultUtil;
import com.qy.demo.demo.one.utils.TbTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-07-17
 */
@RestController
@RequestMapping("/one/tb-item-one")
public class TbItemOneController {

    @Autowired
    private ITbItemOneService itemOneService;

    @Resource
    private TbItemOneMapper itemOneMapper;

    @GetMapping(value = "/add")
    public Result add() {
        long sampleField = 5999;
        TbItemOne itemOne = new TbItemOne();
        itemOne.setTitle("1111");
        itemOne.setCid(sampleField);
        // int i =  itemOneMapper.insert(itemOne);
        //  int i = itemOneService.insert1(itemOne);
        List<TbItemOne> children = new ArrayList<>();
        children.add(itemOne);
        children.add(itemOne);
        //  itemOneService.saveBatch1(children);
        // itemOneService.saveBatch(children);
        return ResultUtil.success(1);
    }

    @GetMapping(value = "/update")
    public Result update() {
        long sampleField = 5999;
        TbItemOne itemOne = new TbItemOne();
        //   itemOne.setId(17);
        itemOne.setTitle("11133122");
        itemOne.setCid(sampleField);
        //  itemOneService.saveOrUpdate(itemOne);   //自动更新
        // UpdateWrapper<TbItemOne> subject_name_cn = new UpdateWrapper<TbItemOne>().eq("id", "7");  // //where更新
        //itemOneService.saveOrUpdate(itemOne,subject_name_cn);
        itemOne.setImage("1111");
        itemOne.setTitle("1111");
        itemOne.setCid(sampleField);
        // int i =  itemOneMapper.insert(itemOne);
        //  int i = itemOneService.insert1(itemOne);
        List<TbItemOne> children = new ArrayList<>();
        children.add(itemOne);
        children.add(itemOne);
        // 批量修改插入
        itemOneService.saveOrUpdateBatch(children);
        // 批量修改插入
        itemOneService.saveOrUpdateBatch(children);
        itemOneService.saveOrUpdateBatch(children, 2);


        itemOneService.update(Wrappers.<TbItemOne>query().lambda().eq(TbItemOne::getId, 3));


        UpdateWrapper<TbItemOne> updateWrapper = new UpdateWrapper<>();
        TbItemOne tbItemOne = new TbItemOne();
        tbItemOne.setTitle("1234@qq.com");
        tbItemOne.setImage("1234567");
        updateWrapper.eq("id", 6);
        itemOneService.update(tbItemOne, updateWrapper);

        itemOneService.update(updateWrapper.set("cid", 222));
        // 根据 ID 选择修改
        itemOneService.updateById(tbItemOne);
        // 根据ID 批量更新
        itemOneService.updateBatchById(children);
        // 根据ID 批量更新
        itemOneService.updateBatchById(children, 2);


        //  itemOneService.update(itemOne);
        return ResultUtil.success(1);

    }


    @GetMapping(value = "/del")
    public Result del() {
        //删除
        itemOneService.remove(Wrappers.<TbItemOne>query().lambda().eq(TbItemOne::getId, 3));

        itemOneService.removeById(11);

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("cid", "88777");
        itemOneService.removeByMap(columnMap);

        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        itemOneService.removeByIds(idList);
        return ResultUtil.success();
    }


    @GetMapping(value = "/get")
    public Result get() {
        TbItemOne itemOne = itemOneService.getById(9);
        // 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")
        //implements Serializable

        itemOneService.getOne(Wrappers.<TbItemOne>query().lambda().eq(TbItemOne::getId, 3));
        // 根据 Wrapper，查询一条记录
        itemOneService.getOne(Wrappers.<TbItemOne>query().lambda().eq(TbItemOne::getId, 3));
        // 根据 Wrapper，查询一条记录
        Map<String, Object> columnMap = new HashMap<>();
        columnMap = itemOneService.getMap(Wrappers.<TbItemOne>query().lambda().eq(TbItemOne::getId, 9));
        // 根据 Wrapper，查询一条记录
        //<V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
        return ResultUtil.success(columnMap);


    }


    @GetMapping(value = "/list")
    public Result list() {

        // 查询所有
        List<TbItemOne> list = itemOneService.list();
        // 查询列表
        //    List<T> list(Wrapper<T> queryWrapper);
        // 查询（根据ID 批量查询）
        //    Collection<T> listByIds(Collection<? extends Serializable> idList);
        List<Integer> idList = new ArrayList<>();
        idList.add(2);
        Collection<TbItemOne> list2 = itemOneService.listByIds(idList);
        // 查询（根据 columnMap 条件）
        //   Collection<T> listByMap(Map<String, Object> columnMap);

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("cid", "88777");
        itemOneService.listByMap(columnMap);

        // 查询所有列表
        //   List<Map<String, Object>> listMaps();
        // 查询列表
        ///  List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper);

        itemOneService.listMaps(Wrappers.<TbItemOne>query().lambda().eq(TbItemOne::getId, 3));

        // 查询全部记录
        //  List<Object> listObjs();
        // 查询全部记录
        //<V> List<V> listObjs(Function<? super Object, V> mapper);
        // 根据 Wrapper 条件，查询全部记录
        // List<Object> listObjs(Wrapper<T> queryWrapper);
        // 根据 Wrapper 条件，查询全部记录
        //<V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);


        return ResultUtil.success(list2);
    }


    @GetMapping(value = "/q")
    public Result q() {

        return ResultUtil.success();
    }

    @GetMapping(value = "/page")
    public Result page() {

        LambdaQueryWrapper<TbItemOne> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper.like(TbItemOne::getTitle, "1111");

        Page<TbItemOne> userPage = new Page<>(1, 2);
        IPage<TbItemOne> userIPage = itemOneService.page(userPage, userLambdaQueryWrapper);
        System.out.println("总页数： " + userIPage.getPages());
        System.out.println("总记录数： " + userIPage.getTotal());
        userIPage.getRecords().forEach(System.out::println);


        Page<Map<String, Object>> userPage2 = new Page<>(1, 2);
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("cid", "111");

        IPage<Map<String, Object>> userIPage2 = itemOneService.pageMaps(userPage2);

        // 无条件分页查询
      /*  IPage<T> page(IPage<T> page);
        // 条件分页查询
        IPage<T> page(IPage<T> page, Wrapper<T> queryWrapper);
        // 无条件分页查询
        IPage<Map<String, Object>> pageMaps(IPage<T> page);
        // 条件分页查询
        IPage<Map<String, Object>> pageMaps(IPage<T> page, Wrapper<T> queryWrapper);*/

        return ResultUtil.success(userIPage2);
    }

    @GetMapping(value = "/query")
    public Result query() {
        List<TbItemOne> list2 = new QueryChainWrapper<>(itemOneMapper).eq("id", 2)
                .orderByDesc("id").list();
        System.out.println("QueryChainWrapper:" + list2);
        List<TbItemOne> list3 = new LambdaQueryChainWrapper<>(itemOneMapper)
                .orderByDesc(TbItemOne::getId).list();
        System.out.println("LambdaQueryChainWrapper:" + list3);
        LambdaQueryWrapper<TbItemOne> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(TbItemOne::getTitle, "liangd1");
        TbItemOne selectOne = itemOneMapper.selectOne(queryWrapper);
        System.out.println(selectOne);
        return ResultUtil.success(list2);
    }


    @GetMapping(value = "/update2")
    public void update2() {

        UpdateWrapper<TbItemOne> updateWrapper = new UpdateWrapper<>();
        updateWrapper.in("age", Arrays.asList(20, 30, 40));
        updateWrapper.set("name", "jack");
        updateWrapper.set("age", 43);
        updateWrapper.set("email", "sakara@qq.top");
        itemOneService.update(updateWrapper);

        TbItemOne tbItemOne = new TbItemOne();

        itemOneMapper.update(tbItemOne, new LambdaQueryWrapper<TbItemOne>()
                .eq(TbItemOne::getTitle, "2222")
        );
        LambdaQueryWrapper<TbItemOne> queryWrapper = new LambdaQueryWrapper<>();

    }

    //分页
    @GetMapping(value = "/delete")
    public Result delete() {
        List<TbItemOne> list = itemOneService.list();
        TbTest test = new TbTest();
        test.setData(list);


        Page<TbItemOne> page = new Page<>(1, 2);
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("cid", "111");

        LambdaQueryWrapper<TbItemOne> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        //userLambdaQueryWrapper.like(TbItemOne::getTitle, "111");
        List<String> typeList = new ArrayList<>();
        typeList.add("1111");

        System.out.println(typeList);

        userLambdaQueryWrapper.in(TbItemOne::getTitle, typeList);
        //  void pageMaps(Page<TbItemOne> page);
        IPage<TbItemOne> tbItemOne = itemOneService.page(page, userLambdaQueryWrapper);


        //  IPage<TbItemOne> tbItemOne =   itemOneService.pageMaps(page,userLambdaQueryWrapper);


//   IPage<Map<String, Object>> userIPage2 =


        // 根据 entity 条件，删除记录
        //  int delete(@Param(Constants.WRAPPER) Wrapper<T> wrapper);
        // 删除（根据ID 批量删除）
        // int deleteBatchIds(@Param(Constants.COLLECTION) Collection<? extends Serializable> idList);
        // 根据 ID 删除
        /// int deleteById(Serializable id);
        // 根据 columnMap 条件，删除记录
        //  int deleteByMap(@Param(Constants.COLUMN_MAP) Map<String, Object> columnMap);
      /*  @Select({
                "select user_id, user_name, age, address " +
                        "from student" +
                        "where user_id = #{userQueryVI.userId} " +
                        "order by create_time desc"
        })
        List<StudentVO> selectStudentListBySelective(Page<StudentVO> page, @Param("studentQueryVI") StudentQueryVI studentQueryVI);*/


        return ResultUtil.success(tbItemOne);
    }

    @GetMapping(value = "/mapper")
    public Result itemOneMapper() {
        TbItemOne itemOne = itemOneMapper.getByBizUserId(2);
        String itemOne22 = itemOneMapper.getUserIdByUnionId(2);
        return ResultUtil.success(itemOne);
    }

    @GetMapping(value = "/mapper2")
    public ResponseEntity<String> itemOneMapper222() {
        TbItemOne itemOne = itemOneMapper.getByBizUserId(2);
        String itemOne22 = itemOneMapper.getUserIdByUnionId(2);
         //return new ResponseEntity<>("Your age is " + itemOne22,HttpStatus.OK);

        return ResponseEntity.ok().build();
    }
}


