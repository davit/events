<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/events.css" type="text/css" />
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
                    <c:choose>
                        <c:when test="${event == 'empty'}">
                            <p class="event">No events were found :(</p>                            
                            <div class="table-div">
                                <div class="new-row">
                                    <button id="add-event" class="btn btn-success">Add new events</button>
                                </div>
                                <table class="table">
                                    <tr>
                                        <th>Cities</th>
                                    </tr>   
                                    
                                    <tr data-event-status="new" contenteditable="true">
                                        <td></td>
                                    </tr>                                                                            
                                </table>
                            </div>                           
                        </c:when>                        
                        <c:otherwise>
                            <div class="table-div">
                                <div class="new-row">
                                    <button id="add-event" class="btn btn-success">Add new cities</button>
                                </div>
                                <table class="table">
                                    <tr>
                                        <th>Cities</th>
                                    </tr>   
                                    <c:forEach items="${cities}" var="event">                                
                                        <tr data-event-status="old" data-cityid="${event.getId()}" contenteditable="true">
                                            <td>${event.getEventName()}</td>
                                        </tr>                                    
                                    </c:forEach>   
                                </table>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="submit-div">
                        <button id="save-changes" class="btn btn-primary">Save Changes</button>
                        <span class="success" hidden="">Saved</span>
                    </div>
                </div>
            </div>
        </div>
                        
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="js/events.js"></script>
    </body>
</html>
