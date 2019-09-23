package com.hu.kittyadmin.service.impl;

import com.hu.kittyadmin.entity.SysUserToken;
import com.hu.kittyadmin.mapper.SysUserTokenMapper;
import com.hu.kittyadmin.service.ISysUserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hu.kittyadmin.util.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用户Token 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-08-28
 */
@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserToken> implements ISysUserTokenService {

    // 12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public SysUserToken findByToken(String token) {
        return baseMapper.findByToken(token);
    }

    @Override
    public SysUserToken findByUserId(Long userId) {

        return baseMapper.findByUserId(userId);
    }

    @Override
    public SysUserToken createToken(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateToken();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime()+EXPIRE*1000);
        //判断是否生成token
        SysUserToken sysUserToken =  findByUserId(userId);

        if(sysUserToken == null){
            sysUserToken = new SysUserToken();
            sysUserToken.setUserId(userId);
            sysUserToken.setToken(token);
            sysUserToken.setExpireTime(expireTime);
            sysUserToken.setLastUpdateTime(now);
            // 保存token，这里选择保存到数据库，也可以放到Redis或Session之类可存储的地方
            save(sysUserToken);
        }else {
            sysUserToken.setUserId(userId);
            sysUserToken.setLastUpdateTime(now);
            sysUserToken.setExpireTime(expireTime);
            // 如果token已经生成，则更新token的过期时间
            updateById(sysUserToken);
        }
        return sysUserToken;
    }
}
