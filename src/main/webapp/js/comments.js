/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(() => {
    $("form#commentSection").on("submit", onCommentSubmit);
    $(document).on("click", ".comment .comment-edit", onCommentEditClick);
    $(document).on("click", ".comment .comment-delete", onCommentDeleteClick);
});

function onCommentSubmit(e) {
    e.preventDefault();

    if (!e.target.checkValidity())
        return;

    const editMode = $("#commentSection .comment-save-row").hasClass("edit-mode");

    $.ajax({
        url: $(e.target).attr("action"),
        data: new FormData(e.target),
        processData: false,
        type: $(e.target).attr("method"),
        error: (jqXHR, textStatus) => {
            console.error("Comment submit failed.");
            console.error(jqXHR);
            console.error(textStatus);
            $(e.target).toggleClass('was-validated', false);
        },
        success: () => {
            $(e.target).toggleClass('was-validated', false);

        }
    });

    return false;
}

function onCommentEditClick(e) {
    const editUrl = $(e.target).data("edit-url");
    const comment = $(e.target).closest(".comment");
    const text = comment.find(".comment-text").text().trim();
    const saveRow = $("#commentSection .comment-save-row");
    const saveTextArea = saveRow.find("#saveCommentText");
    const saveButton = saveRow.find("#submitCommentEdit");

    saveRow.toggleClass("edit-mode", true);
    saveButton.data("edit-target", comment);
    saveButton.attr("formaction", editUrl);
    saveTextArea.val(text);
}

function onCommentDeleteClick(e) {
    const comment = $(e.target).closest(".comment").remove();
}
