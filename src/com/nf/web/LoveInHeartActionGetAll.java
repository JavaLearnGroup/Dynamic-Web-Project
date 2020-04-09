package com.nf.web;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.entity.LoveInHeart;
//import com.nf.entity.MyData;
import com.nf.service.LoveInHeartService;
import com.nf.service.LoveInHeartServiceImpl;
@WebServlet("/LoveInHeartActionGetAll")
public class LoveInHeartActionGetAll extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //第一步：先获得客户端的参数
        String currentPage_str = request.getParameter("currentPage");
        if (currentPage_str==null){
            currentPage_str = "1";
        }
        int currentPage = Integer.parseInt(currentPage_str);


        //第二步：调用Model（service层）的方法，来获取数据
        LoveInHeartService loveService = new LoveInHeartServiceImpl();
      //  MyData myData = loveService.getAll(currentPage);


        //第三步：把数据存放到request的属性中，然后把请求转发到jsp
    //    request.setAttribute("myData", myData);
        request.getRequestDispatcher("showList.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}