import './App.css';
import {useState} from 'react';

function App() {

  const [todoList, setTodoList] = useState([
    { name: "Buy shopping", priority: "high" },
    { name: "Clean bathroom", priority: "low" },
    { name: "Car's MOT", priority: "high" }
  ])

  const [taskName, setTaskName] = useState("")
  const [priority, setPriority] = useState("");

  const nodeList = todoList.map((task, index) => <li key={index} className={task.priority}> {task.name}</li>)

  const handleTaskInput = (evt) => {
    setTaskName(evt.target.value);
  }

  const handlePrioritySelect = (evt) => {
    setPriority(evt.target.value);
  }

  const saveNewTodo = (evt) => {
    evt.preventDefault();
    const todoListCopy = [...todoList]
    todoListCopy.push({name: taskName, priority: priority})
    setTodoList(todoListCopy)
    setTaskName("")
    setPriority("")
  }

  return (
    <>
      <h1>ToDo's</h1>
      
      <form onSubmit={saveNewTodo} >
        <label htmlFor="new-todo">Add a new todo:</label>
        <input id="new-todo" type="text" onChange={handleTaskInput} value={taskName} />
        <label htmlFor="high">High</label>
        <input id="high" type="radio" checked={priority === "high"}name="prioritySelect" value="high" onChange={handlePrioritySelect} />
        <label htmlFor="low">Low</label>
        <input id="low" type="radio" name="prioritySelect" value="low" onChange={handlePrioritySelect} checked={priority === "low"}/> 
        <input type="submit" value="Save Item" className={"button"}/>
      </form>

      <ul>
        {nodeList}
      </ul>
    </>
  );
}

export default App;



