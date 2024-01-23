import { TodoListApp } from "@packages/shared/src/components/todoList/TodoListApp";
import { useTodoList } from "../store/useTodoList";

export const TodoListHOC = () => {
  const { todoList, dispatch } = useTodoList();

  return <TodoListApp dispatch={dispatch} todoList={todoList} />;
};
