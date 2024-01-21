import { useDispatch, useSelector } from "react-redux";
import { AddTodo } from "@packages/shared/src/components/AddTodo";
import { TodoList } from "@packages/shared/src/components/TodoList";

export const TodoListApp = () => {
  const cash = useSelector((state: any) => state.cash.cash);

  const todoList = useSelector((state: any) => state.todo.todoList);

  const dispatch = useDispatch();

  const addHandle = () => {
    dispatch({ type: "ADD_CASH", payload: 5 });
  };

  const getHandle = () => {
    dispatch({ type: "GET_CASH", payload: 5 });
  };

  const addTodoItem = (todoItemLabel: string) => {
    dispatch({ type: "ADD_TODO_ITEM", payload: todoItemLabel });
  };

  const removeTodoItem = (todoItemId: string) => {
    dispatch({ type: "REMOVE_TODO_ITEM", payload: todoItemId });
  };

  const markAsCompleted = (todoItemId: string) => {
    dispatch({ type: "TOGGLE_COMPLETED", payload: todoItemId });
  };

  return (
    <div>
      <div>{cash}</div>
      <button onClick={addHandle}>add</button>
      <button onClick={getHandle}>get</button>

      <h2>Todo List Redux</h2>
      <AddTodo addTodoItem={addTodoItem} />
      <TodoList
        todoList={todoList}
        removeTodoItem={removeTodoItem}
        markAsCompleted={markAsCompleted}
      />
    </div>
  );
};
