package com.hu.kittyadmin.controller;


import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.hu.kittyadmin.entity.SysUser;
import com.hu.kittyadmin.entity.SysUserToken;
import com.hu.kittyadmin.service.ISysUserService;
import com.hu.kittyadmin.service.ISysUserTokenService;
import com.hu.kittyadmin.util.PasswordUtils;
import com.hu.kittyadmin.util.ShiroUtils;
import com.hu.kittyadmin.vo.LoginBean;
import com.hu.kittycommon.utils.IOUtils;
import com.hu.kittycore.http.HttpResult;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.security.authentication.AuthenticationManager;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * 登录控制器
 * @Author: hy
 * @Date: 2019/8/28
 */
@RestController
public class SysLoginController {

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    ISysUserTokenService sysUserTokenService;

    @Autowired
    DefaultKaptcha producer;

//    @Autowired
//    private AuthenticationManager authenticationManager;

    @GetMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException{
        response.setHeader("Cache-control","no-stroe,no-cache");
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        // 保存到验证码到 session
//        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);
//        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,text);
//        response.addCookie(new Cookie(Constants.KAPTCHA_SESSION_KEY,text));


        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image,"jpg",out);
        IOUtils.closeQuietly(out);


    }


    @PostMapping("/sys/login")
    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException{
       Cookie[] cookies = request.getCookies();
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配
        Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (kaptcha == null){
            return HttpResult.error("验证码已失效");
        }
        if (!captcha.equals(kaptcha)){
            return HttpResult.error("验证码不正确");
        }
        // 用户信息
        SysUser user = sysUserService.findUserByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return HttpResult.error("账号不存在");
        }

        if (!match(user, password)) {
            return HttpResult.error("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0){
            return HttpResult.error("账号已被锁定,请联系管理员");
        }

        // 生成token，并保存到数据库
        SysUserToken data = sysUserTokenService.createToken(user.getId());
        return HttpResult.ok(data);

    }

    /**
     * 验证用户密码
     * @param user
     * @param password
     * @return
     */
    public boolean match(SysUser user, String password) {

        return user.getPassword().equals(PasswordUtils.encrypte(password, user.getSalt()));
    }

    /**
     * 登出接口
     */
    @GetMapping(value = "/sys/logout")
    public HttpResult logout() {
        ShiroUtils.logout();
        return HttpResult.ok();
    }

}
