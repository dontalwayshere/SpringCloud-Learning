package com.matthew.practice.service.impl;


import com.matthew.practice.dao.AccountDao;
import com.matthew.practice.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 账户业务实现类
 * Created by zzyy on 2019/11/11.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Resource
    AccountDao accountDao;

    /**
     * 扣减账户余额
     */
    @Override
    @Transactional
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->account-service中扣减账户余额开始");
        try {
            //模拟超时异常，全局事务回滚
            //暂停几秒钟线程
            //TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // 算数异常 把它捕获了 就会是运行时异常 会继续执行
        int i = 1 / 0;

        accountDao.decrease(userId, money);
        LOGGER.info("------->account-service中扣减账户余额结束");
    }


}
