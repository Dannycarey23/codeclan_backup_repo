import Quote from './Quote'; 

function App() {
  return (
    <div className="App">
      <Quote by="Bill Gates" source="https://www.microsoft.com">
        640kb of memory ought to be enough for anyone
      </Quote>
      <Quote by="Steve Jobs" source="https://www.apple.com">
        Don't let the noise of others' opinions drown out your own inner voice
      </Quote>
    </div>
  );
}

export default App;