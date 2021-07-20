package com.qy.demo.demo.one.service.impl;

import com.qy.demo.demo.one.entity.TbItemOne;
import com.qy.demo.demo.one.mapper.TbItemOneMapper;
import com.qy.demo.demo.one.service.ITbItemOneService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-07-17
 */
@Service
//@AllArgsConstructor
public class TbItemOneServiceImpl extends ServiceImpl<TbItemOneMapper, TbItemOne> implements ITbItemOneService {



    @Resource
    private TbItemOneMapper itemOneMapper;

    @Autowired
    private ITbItemOneService itemOneService;



   /* @Override
    public int del(TbItemOne user) {
        return 0;
    }

    @Override
    public int del(Integer id) {
        return 0;
    }

    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    @Override
    public int insert1(TbItemOne user) {
        return itemOneMapper.insert(user);
    }*/

/*    @Override
    public boolean save(Collection<TbItemOne> entityList) {

        return itemOneService.save(entityList);
    }*/

    /*  @Override
      public boolean save(Collection<TbItemOne> entityList) {
          return false;
      }
  */
    /*@Override
    public boolean saveBatch(Collection<TbItemOne> entityList) {
        return false;
    }


    @Override
    public boolean saveBatch1(Collection<TbItemOne> entityList) {*/

       /* System.out.println(2222);
        System.out.println(user);
        System.out.println(11111);
        return itemOneMapper.saveBatch();
*/
     /*   return false;
    }*/

    /*@Override
    public boolean saveBatch1(Collection<TbItemOne> entityList, int batchSize) {
        return false;
    }
*/
    /*@Override
    public boolean saveBatch1(Collection<TbItemOne> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean remove(TbItemOne user) {
        return false;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }

    @Override
    public boolean removeByMap1(Map<String, Object> columnMap) {
        return false;
    }
*/
}
