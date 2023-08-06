import React, { useState, useEffect } from 'react';
import StoryList from '../components/StoryList';
import Filter from '../components/Filter';

function StoryContainer() {
  const [stories, setStories] = useState([]);
  const [filteredStories, setFilteredStories] = useState([]);

  useEffect(() => {
    fetch("https://hacker-news.firebaseio.com/v0/topstories.json")
      .then(res => res.json())
      .then((data) => {
        const newData = data.slice(0, 20);
        const promises = newData.map((id) => {
          return fetch(`https://hacker-news.firebaseio.com/v0/item/${id}.json`)
            .then(res => res.json());
        });

        Promise.all(promises)
          .then((results) => {
            setStories(results);
            setFilteredStories(results);
          });
      });
  }, []);

  const filter = (searchTerm) => {
    const lowerSearch = searchTerm.toLowerCase();
    const filteredStories = stories.filter((story) => {
      return story.title.toLowerCase().indexOf(lowerSearch) > -1;
    });
    setFilteredStories(filteredStories);
  }

  return (
    <>
      <Filter handleChange={filter} />
      <StoryList stories={filteredStories} />
    </>
  )
}

export default StoryContainer;
