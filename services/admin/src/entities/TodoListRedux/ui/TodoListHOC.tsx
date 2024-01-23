import { useDispatch, useSelector } from "react-redux";
import { TodoListApp } from "@packages/shared/src/components/todoList/TodoListApp";

export const TodoListHOC = () => {
  const todoList = useSelector((state: any) => state.todo.todoList);

  const dispatch = useDispatch();

  return <TodoListApp dispatch={dispatch} todoList={todoList} />;
};
