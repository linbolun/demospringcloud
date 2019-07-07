package com.demospringcloud.eurekaclient.eurekaclient.service.impl;

import com.demospringcloud.eurekaclient.eurekaclient.mapper.UserMapper;
import com.demospringcloud.eurekaclient.eurekaclient.pojo.User;
import com.demospringcloud.eurekaclient.eurekaclient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service("UserService")
@Transactional(rollbackFor=Exception.class)
public class UserServieImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServieImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public int saveUser(User user) {
        int result = 0;
        try{
            result = userMapper.insertUser(user);
            System.out.println("插入返回"+result);
            if(result==0){
                logger.error("插入失败，事务回滚");
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }
        }catch (Exception e){
            logger.error("插入异常，事务回滚");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();

        }
        return result;
    }
    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(String message){
        System.out.println("message:"+message);
    }
}
