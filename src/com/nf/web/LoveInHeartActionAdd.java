package com.nf.web;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.entity.LoveInHeart;
import com.nf.service.LoveInHeartService;
import com.nf.service.LoveInHeartServiceImpl;
@WebServlet("/LoveInHeartActionAdd")
public class LoveInHeartActionAdd extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        //?lname=123&lsex=男&ltime=111&lmoney=222
        String lname = request.getParameter("name");
        String lsex = request.getParameter("sex");
        String ltime = request.getParameter("time");
        String lmoney = request.getParameter("money");
        //把参数构造成一个实体类
        LoveInHeart love = new LoveInHeart();
        love.setName(lname);
        love.setSex(lsex);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            love.setTime( new java.sql.Date( sdf.parse(ltime).getTime() ) );
        } catch (ParseException e) {
            System.out.println("日期格式转换错误");
            e.printStackTrace();
        }
        love.setMoney( Float.parseFloat(lmoney) );

        //调用Model，保存数据
        LoveInHeartService loveService = new LoveInHeartServiceImpl();
        boolean flag = loveService.add(love);

        //跳转
        if (flag){
            //response.sendRedirect("showList.jsp");
            response.sendRedirect("LoveInHeartActionGetAll");


        }else{
            response.sendRedirect("error.jsp");
        }


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}

