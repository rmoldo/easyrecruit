<%-- 
    Document   : setInterview
    Created on : Jan 12, 2021, 10:07:39 PM
    Author     : Dragos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Request Interview">
    <html>
        <head>
         <link href="css/setInterviewStyle.css" rel="stylesheet" type="text/css">   
        </head>
        <body>              
            <div class="testbox">
                <c:if test="${interview_error_message != null}">
                <div class="alert alert-warning" role="alert">
                    ${interview_error_message}
                </div>
                </c:if>
                <c:if test="${interview_status_message != null}">
                    <div class="alert alert-info" role="alert">
                        ${interview_status_message}
                      </div>
                </c:if>
                <form method="POST">
                    <input type="hidden"  id="candidateId" name="positionId" value="${candidateId}" required>
                    <input type="hidden"  id="positionId" name="commentId" value="${positionId}" required>
                    <div class="banner">
                      <h1>Set Interview</h1>
                    </div>
                    <br/>
                    <fieldset>
                        <legend>Information required for setting up an interview:</legend> 
                        <div class="item">
                          <label for="fname">Interviewer<span>*</span></label>
                          <input id="fname" type="text" name="interviewer" required/>
                        </div>
                        <div class="item">
                          <label for="activity">Type of Interview<span>*</span></label>
                          <input id="activity" type="text" name="typeOfInterview" required/>
                        </div>
                          <div class="item">
                           <label for="bdate">Interview Date <span>*</span></label>
                           <input id="bdate" type="date" name="date" required/>
                           <i class="fas fa-calendar-alt"></i>
                        </div>
                        <div class="item">
                          <label for="comment">Comment</label>
                          <input name="comment" />
                        </div>  
                    </fieldset>
                    <div class="btn-block">
                        <button type="submit">Submit</button>
                    </div>
                </form> 
            </div>
        </body>
    </html>
</t:pageTemplate>