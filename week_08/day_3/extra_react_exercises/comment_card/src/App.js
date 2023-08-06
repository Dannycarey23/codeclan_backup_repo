import {useState} from 'react';
import CommentCard from './CommentCard';

function App() {

  const [comments, setComments] = useState([
    {
      imageUrl: "https://picsum.photos/100", 
      userName: "William Wise", 
      datePosted: new Date(2022, 7, 1), 
      comment: "This comment is the wisest thing you've ever read" 
    },
    {
      imageUrl: "https://picsum.photos/100/100", 
      userName: "Buddha", 
      datePosted: new Date(600, 6, 18), 
      comment: "As your focus transcends all types of objects, Unfixed on any mark of concreteness, Remain quiet, tranquil and awake!" 
    }
  ]);

  const cards = comments.map( (commentObj, i) => {
    return( 
      <CommentCard key={i}
        imageUrl={commentObj.imageUrl}
        userName={commentObj.userName} 
        datePosted={commentObj.datePosted} >
          {commentObj.comment}
      </CommentCard>
    )
  } );

  return (
    <ul>{cards}</ul>
  )

}

export default App;
