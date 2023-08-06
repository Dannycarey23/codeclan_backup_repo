import React from "react";
import Comment from "./Comment";

const CommentList = ({comments}) => {

  const commentNodes = comments.map(comment => {
    return (
      <Comment author={comment.author} key={comment.id}>{comment.text}</Comment>
    );
  });

  return(
    <ul id="comment-list">
      {commentNodes}
    </ul>
  )

}

export default CommentList;