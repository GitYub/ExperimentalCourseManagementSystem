package com.ncu.sysweb.controller;

import com.ncu.sysweb.util.VerifyCodeUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class AuthCodeController {

    @GetMapping(value = "/authCode")
    public void getVerifyCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("进入");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字符串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入Session, 此处可以根据自己的需求
        HttpSession session = request.getSession();
        session.setAttribute("verifyCode", verifyCode);

        //生成图片
        int w = 100, h = 35;
        //将图片写入到 response 的输出流即可将图片返回到客户端了
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }
}
