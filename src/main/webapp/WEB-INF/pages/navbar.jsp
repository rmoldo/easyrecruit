<%--
    Document   : navbar
    Created on : Nov 8, 2020, 11:49:12 AM
    Author     : andrei
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("forwardPath", request.getAttribute(RequestDispatcher.FORWARD_SERVLET_PATH)); %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%-- TODO: TMP move --%>
<%!
    enum UserType {
        Normal,
        Administrator,
        GeneralDirector,
        DepartmentDirector,
        HRDirector,
        Recruiter
    }
%>
<%
    pageContext.setAttribute("userType", UserType.Normal);
    pageContext.setAttribute("userName", "Xulescu");
%>


<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">
        EasyRecruit
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${forwardPath == '/Positions' ? ' active' : ''}">
                <a class="nav-link" href="${contextPath}/Positions">Positions</a>
            </li>
            <c:if test="${userType == 'Normal'}">
                <li class="nav-item ${forwardPath == '/Applications' ? ' active' : ''}">
                    <a class="nav-link" href="${contextPath}/Applications">My Applications</a>
                </li>
            </c:if>
            <c:if test="${userType == 'Administrator' || userType == 'GeneralDirector'}">
                <li class="nav-item ${forwardPath == '/Users' ? ' active' : ''}">
                    <a class="nav-link" href="${contextPath}/Users">Users</a>
                </li>
            </c:if>
        </ul>

        <ul class="navbar-nav ml-auto">
            <c:if test="${userType == null}">
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/login.jsp">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/register.jsp">Register</a>
                </li>
            </c:if>
            <c:if test="${userType != null}">
                <li class="nav-item navbar-text">
                    Welcome back ${userName}
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${contextPath}/Profile">Profile</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
