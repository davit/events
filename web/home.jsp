<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/home.css" type="text/css" />
        <title>Home Page</title>
    </head>
    <body>        
        
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-lg-push-4">                    
                    <div id="pageLinks" class="links">                    
                        <div class="links home-page">
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/login" role="button">
                                <img src="images/login.png">
                            </a>
                        </div>
                        <div class="links calendar">
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/events" role="button">
                                <img src="images/table-icon.png">
                            </a>
                        </div>
                        <div class="links cities">
                            <a class="btn btn-default" href="${pageContext.request.contextPath}/cities" role="button">
                                <img src="images/city-icon.png">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
