package com.qy.demo.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qy.demo.demo.entity.TbItem;
import com.qy.demo.demo.mapper.TbItemMapper;
import com.qy.demo.demo.service.ITbItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-07-15
 */
@Service
public class TbItemServiceImpl extends ServiceImpl<TbItemMapper, TbItem> implements ITbItemService {

}
