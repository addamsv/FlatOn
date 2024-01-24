import { AddTodo } from "./AddTodo";
import { TodoList } from "./TodoList";
import {
  addTodoAction,
  remTodoAction,
  togTodoAction,
} from "../store/todoListReducer";
import { fetchTodo } from "../api";
import style from "./styles.module.scss";

export const TodoListApp = ({ todoList, dispatch }: any) => {
  const addTodoItem = (todoItemLabel: string) => {
    dispatch(addTodoAction(todoItemLabel));
  };

  const removeTodoItem = (todoItemId: string) => {
    dispatch(remTodoAction(todoItemId));
  };

  const markAsCompleted = (todoItemId: string) => {
    dispatch(togTodoAction(todoItemId));
  };

  const addManyValueHandler = () => {
    fetchTodo()(dispatch);
  };

  return (
    <div>
      <div className={style.brwsr}>
        <h2>Todo List</h2>
        <AddTodo addTodoItem={addTodoItem} />
        <button onClick={addManyValueHandler}>Add from server</button>
        <TodoList
          todoList={todoList}
          removeTodoItem={removeTodoItem}
          markAsCompleted={markAsCompleted}
        />
      </div>
    </div>
  );
};
