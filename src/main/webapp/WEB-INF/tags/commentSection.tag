<%-- 
    Document   : commentSection
    Created on : Jan 15, 2021, 5:32:46 PM
    Author     : andrei
--%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="message"%>

<form id="commentSection" class="needs-validation" novalidate method="POST"
      action="/ActionComments?positionId=${application.position.id}&candidateId=${application.candidate.id}">

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
                            formaction="/ActionComments?">
                        Save
                    </button>
                </td>
            </tr>
        </thead>
        <tbody>
            <t:commentRow
                username="Mihai Someone" 
                time="20/19/1111 at 18:30"
                text="Lorem ipsum dolor sit amet, consectetur adipiscing elit."
                editable="true"
                editUrl="/ActionComments?id=123" />
            <t:commentRow
                username="Mihai Someone" 
                time="20/19/1111 at 18:30"
                text="Lorem ipsum dolor sit amet, consectetur adipiscing elit." />

            <tr class="no-comments-message text-center">
                <td colspan="99">No comments yet.</td>
            </tr>
            <t:commentRow
                className="comment-template"
                username="((username))" 
                time="((time))"
                text="((text))"
                editable="true"/>
        </tbody>
    </table>
</form>