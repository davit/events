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
                    <div class="links home">
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/home" role="button">
                            <img src="${pageContext.request.contextPath}/images/home-icon.png">
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>
