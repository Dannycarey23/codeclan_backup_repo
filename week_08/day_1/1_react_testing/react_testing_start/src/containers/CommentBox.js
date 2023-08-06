import React, {useState} from "react";
import CommentList from "../components/CommentList";
import CommentForm from "../components/CommentForm";

const CommentBox = () => {

  const [comments, setComments] = useState(
    [
      {
        id: 1,
        author: "Rick Henry",
        text: "React is such a great framework!"
      },
      {
        id: 2,
        author: "Valerie Gibson",
        text: "I'm dreaming in React..."
      }
    ]
  )

  const addComment = (submittedComment) => {
    submittedComment.id = Date.now();
    const updatedComments = [...comments, submittedComment];
    setComments(updatedComments);
  }

  return (
    <>
      <h1>Comments</h1>
      <CommentList comments={comments} />
      <h2>Add a comment:</h2>
      <CommentForm onCommentSubmit={(comment) => addComment(comment)}/>
    </>
  );

}

export default CommentBox;