import { AddTodo } from "./AddTodo";
import { TodoList } from "./TodoList";
import { useEffect } from "react";
import style from "./styles.module.scss";
import { UserList } from "./UserList";
import {
  addTodoAction,
  fetchTodo,
  remTodoAction,
  setTodoPageAction,
  togTodoAction,
} from "../store/actionCreator/todoList";
import { Pagination } from "./Pagination";
import { TodoListStateT } from "../types/todoList";

export const TodoListApp = ({
  todo,
  dispatch,
  users,
}: {
  todo: TodoListStateT;
  dispatch: any;
  users?: any;
}) => {
  const addTodoItem = (todoItemLabel: string) => {
    dispatch(addTodoAction(todoItemLabel));
  };

  const removeTodoItem = (todoItemId: string) => {
    dispatch(remTodoAction(todoItemId));
  };

  const markAsCompleted = (todoItemId: string) => {
    dispatch(togTodoAction(todoItemId));
  };

  useEffect(() => {
    fetchTodo(dispatch, todo.page, todo.limit);
  }, [todo.page]);

  const setPage = (num: number) => {
    dispatch(setTodoPageAction(num));
  };

  if (todo.isLoading) {
    return <h2>loading...</h2>;
  }

  if (todo.error) {
    return <h2>{todo.error}</h2>;
  }

  return (
    <div>
      <div className={style.brwsr}>
        {users ? <UserList users={users} dispatch={dispatch} /> : undefined}
        <h2>Todo List</h2>
        <AddTodo addTodoItem={addTodoItem} />
        {/* <button onClick={addManyValueHandler}>Add from server</button> */}
        <TodoList
          todoList={todo.todoList}
          removeTodoItem={removeTodoItem}
          markAsCompleted={markAsCompleted}
          page={todo.page}
          // limit={todo.limit}
        />
        <Pagination
          pages={[1, 2, 3, 4, 5]}
          page={todo.page}
          pageChangeHandler={setPage}
        />
      </div>
    </div>
  );
};
