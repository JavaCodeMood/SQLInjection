<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath(); %>
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html>  
<html>  
    <head>  
        <meta charset="utf-8" />  
        <title>修改密码</title>   
        <link href="<%=basePath %>css/bootstrap.min.css" rel="stylesheet">  
        <link href="<%=basePath %>css/font-awesome.min.css" rel="stylesheet">  
        <script src="<%=basePath %>js/jquery-3.1.0.min.js"></script>   
        <script src="<%=basePath %>js/bootstrap.min.js"></script>  
        <style type="text/css">  
            body{background: url(img/4.jpg) no-repeat;background-size: <span style="font-family: 微软雅黑; background-color: rgb(239, 239, 239);">cover</span>;font-size: 16px;}  
            .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}  
            #login_form{display: block;}  
            #register_form{display: none;}  
            .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}  
            input[type="text"],input[type="password"]{padding-left:26px;}  
            .checkbox{padding-left:21px;}  
        </style>  
    </head>  
    
    <body>  
    <div class="container">  
        <div class="form row">  
            <form class="form-horizontal col-sm-offset-3 col-md-offset-3" action="alterPW.do" method="post">  
                   <h3 class="form-title">${user.name }修改密码</h3>  
                <div class="col-sm-9 col-md-9">  
                    <div class="form-group">  
                          
                        <input class="form-control required" type="password" placeholder="旧密码" name="password1" autofocus="autofocus" />  
                    </div>  
                    <div class="form-group">  
                            <input class="form-control required" type="password" placeholder="新密码" name="password2" />  
                    </div>  
                    <div class="form-group">  
                       <hr/> 
                    </div>  
                    <div class="form-group">  
                        <input type="submit" class="btn btn-success pull-right" value="确认修改 "/>     
                    </div>  
                </div>  
            </form>  
        </div>  
        </div>  
    </body>  
</html>  