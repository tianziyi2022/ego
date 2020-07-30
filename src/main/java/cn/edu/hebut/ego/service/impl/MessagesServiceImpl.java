package cn.edu.hebut.ego.service.impl;

import cn.edu.hebut.ego.entity.Messages;
import cn.edu.hebut.ego.mapper.MessagesMapper;
import cn.edu.hebut.ego.service.IMessagesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tianziyi
 * @since 2020-07-30
 */
@Service
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements IMessagesService {

}
