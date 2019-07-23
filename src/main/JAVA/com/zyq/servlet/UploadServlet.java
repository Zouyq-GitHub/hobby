package com.zyq.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UploadServlet" , value = "/pages/UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        //文件上传的表单 无法使用该方式获取信息
        String descString=request.getParameter("desc");
        //准备需要的工具类 工厂类
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();
        //
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        //使用工具类 去解析 request对象 获取 所有的文件信息(包括表单中的普通属性)
        try {
            List<FileItem> fileItems=servletFileUpload.parseRequest(request);
            //遍历
            for (FileItem fileItem : fileItems) {
                //判断该文件项是不是一个文件
                if(fileItem.isFormField()) {//文本框/输入框等等
                    System.out.println("表单name属性:"+fileItem.getFieldName());
                    System.out.println("输入框对应的值"+fileItem.getString());
                }else {
                    //该文件项是一个文件
                    System.out.println("文件名称"+fileItem.getName());
                    //未处理的文件名
                    String fileType=fileItem.getName();
                    //判断该文件名中是否还有路径
                    int i=fileType.lastIndexOf(".");
                    if(i!=-1) {
                        fileType=fileType.substring(i);
                    }
                    //文件名
                    String fileName=System.currentTimeMillis()+fileType;
                    //io的内容 将文件保存在服务中
                    InputStream inputStream=fileItem.getInputStream();
                    //文件保存位置
                    //动态获取当前项目的路径

                    String path=request.getRealPath("/");

                    System.out.println(path);

                    OutputStream outputStream=new FileOutputStream(path+fileName);
                    BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(outputStream);
                    //
                    byte[] bytes=new byte[1024*8];
                    //
                    while(inputStream.read(bytes)!=-1) {
                        bufferedOutputStream.write(bytes);
                        bufferedOutputStream.flush();
                    }
                    //关闭资源
                    bufferedOutputStream.close();
                    outputStream.close();
                    inputStream.close();
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        response.sendRedirect("TableServlet");
    }*/


        //跳
        request.getRequestDispatcher("Table.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
