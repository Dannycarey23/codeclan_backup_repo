import React from 'react';

const Story = ({ details, position }) => (
  <li>
    <article>
      <h1><a href={details.url}>{details.title}</a></h1>
      <p>Posted by {details.by}.</p>
    </article>
  </li>
);

export default Story;
