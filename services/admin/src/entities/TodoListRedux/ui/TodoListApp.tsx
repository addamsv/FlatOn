import { useDispatch, useSelector } from "react-redux";
import { AddTodo } from "@packages/shared/src/components/AddTodo";
import { TodoList } from "@packages/shared/src/components/TodoList";
import {
  addTodoAction,
  remTodoAction,
  togTodoAction,
} from "../store/todoListReducer";

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
    dispatch(addTodoAction(todoItemLabel));
  };

  const removeTodoItem = (todoItemId: string) => {
    dispatch(remTodoAction(todoItemId));
  };

  const markAsCompleted = (todoItemId: string) => {
    dispatch(togTodoAction(todoItemId));
  };

  return (
    <div>
      <div
        style={{
          border: "#aaa solid 1px",
          width: "fit-content",
          padding: 10,
          margin: 5,
        }}
      >
        <div>{cash}</div>
        <button onClick={addHandle}>add</button>
        <button onClick={getHandle}>get</button>
      </div>
      <div
        style={{
          border: "#aaa solid 1px",
          width: "fit-content",
          padding: 10,
          margin: 5,
        }}
      >
        <h2>Todo List Redux</h2>
        <AddTodo addTodoItem={addTodoItem} />
        <TodoList
          todoList={todoList}
          removeTodoItem={removeTodoItem}
          markAsCompleted={markAsCompleted}
        />
      </div>
    </div>
  );
};
