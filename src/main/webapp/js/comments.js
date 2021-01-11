/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(() => {
    $("form#comments").on("submit", onCommentSubmit);
    $(document).on("click", ".comment .comment-edit", onCommentEditClick);
    $(document).on("click", ".comment .comment-delete", onCommentDeleteClick);
});

function onCommentSubmit(e) {
    e.preventDefault();

    if (!e.target.checkValidity())
        return;

    $.ajax({
        url: $(e.target).attr("action"),
        data: new FormData(e.target),
        processData: false,
        type: $(e.target).attr("method"),
        error: (jqXHR, textStatus) => {
            console.error("Comment submit failed.");
            console.error(jqXHR);
            console.error(textStatus);
        },
        success: () => {

        }
    });

    return false;
}

function onCommentEditClick(e) {
    const comment = $(e.target).closest(".comment");

    const text = comment.text();

    console.log("edit", comment);
}

function onCommentDeleteClick(e) {
    const comment = $(e.target).closest(".comment").remove();
}
