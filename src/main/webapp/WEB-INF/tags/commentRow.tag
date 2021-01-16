<%-- 
    Document   : commentRow
    Created on : Jan 12, 2021, 5:50:30 PM
    Author     : andrei
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="className"%>
<%@attribute name="username" required="true"%>
<%@attribute name="time" required="true"%>
<%@attribute name="text" required="true"%>
<%@attribute name="editable"%>
<%@attribute name="editUrl"%>


<tr class="comment ${className} ${editable ? 'comment-editable' : ''}">
    <td class="column-fit text-nowrap">
        <span class="comment-username">${username}</span>
        <br />
        <small class="comment-time">${time}</small>
    </td>
    <td class="comment-text">
        ${text}
    </td>
    <td class="column-fit">
        <button type="button" class="btn btn-light comment-edit-btn"
                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"
                data-edit-url="${editUrl}">
            <i class="bi bi-three-dots-vertical"></i>
        </button>
        <div class="dropdown-menu dropdown-menu-right">
            <button class="comment-edit dropdown-item" type="button">Edit</button>
            <button class="comment-delete dropdown-item text-danger" type="button">Delete</button>
        </div>
    </td>
</tr>