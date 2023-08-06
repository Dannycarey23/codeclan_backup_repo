import React from "react";

const Comment = ({author, children}) => {

  return(
    <li>
      <h4>{children}</h4>
      <p>{author}</p>
    </li>
  )

}

export default Comment;