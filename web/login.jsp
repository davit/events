<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" />
        <title>Login Page</title>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <div id="login-form" class="col-lg-4 col-lg-push-4">
                    <div class="links home">
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/home" role="button">
                            <img src="${pageContext.request.contextPath}/images/home-icon.png">
                        </a>
                    </div>
                    <div class="authentication">
                        <form action="authenticate" method="post">
                            <div class="form-group">
                                <label for="userName">User name</label>
                                <input type="text" name="uname" class="form-control" id="userName" placeholder="Enter user name">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" name="password" class="form-control" id="password" placeholder="Password">
                            </div>   
                            <div class="submit-div">
                                <button id="submitButton" type="submit" class="btn btn-primary">Log in</button>
                                <c:if test="${not empty errorMessage}">
                                    <span class="error-message"> ${errorMessage} </span>                                
                                </c:if>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="${pageContext.request.contextPath}/js/login.js"></script>
    </body>
</html>
