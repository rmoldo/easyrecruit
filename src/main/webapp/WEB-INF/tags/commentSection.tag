<%-- 
    Document   : commentSection
    Created on : Jan 15, 2021, 5:32:46 PM
    Author     : andrei
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="comments" required="true" type="java.util.Collection"%>
<%@attribute name="editableCommentsUserId"%>
<%@attribute name="positionId"%>
<%@attribute name="candidateId"%>
<%@attribute name="servletUrl"%>


<form id="commentSection" class="needs-validation" novalidate method="POST"
      action="${servletUrl}?positionId=${positionId}&candidateId=${candidateId}">
    <table class="table table-sm table-borderless">
        <thead>
            <tr class="comment-save-row">
                <td colspan="2">
                    <textarea id="saveCommentText" class="form-control" name="text" placeholder="New Comment" required></textarea>
                    <div class="invalid-feedback">
                        Comment text is required.
                    </div>
                </td>
                <td>
                    <button id="submitNewComment" class="btn btn-primary" type="submit">
                        Submit
                    </button>
                    <button id="submitCommentEdit" class="btn btn-success" type="submit"
                            formaction="">
                        Save
                    </button>
                </td>
            </tr>
        </thead>
        <tbody class="comment-rows-container">
            <c:forEach var="comment" items="${comments}">
                <t:commentRow
                    username="${comment.user.firstName} ${comment.user.lastName}" 
                    time="${comment.dateTimeString}"
                    text="${comment.text} ${editableCommentsUserId}"
                    editable="${comment.user.id == editableCommentsUserId}"
                    editUrl="${servletUrl}?id=${comment.id}" />
            </c:forEach>
            <tr class="no-comments-message text-center">
                <td colspan="99">No comments yet.</td>
            </tr>
            <t:commentRow
                className="comment-template"
                username="((username))" 
                time="((time))"
                text="((text))"
                editable="true"
                editUrl="${servletUrl}?id=((id))"/>
        </tbody>
    </table>
</form>