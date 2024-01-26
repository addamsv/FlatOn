import { TodoListApp } from "@packages/shared/src/components/todoList";
import { useTodoList } from "../hooks/useTodoList";

export const TodoListHOC = () => {
  const { todo, dispatch } = useTodoList();

  return <TodoListApp dispatch={dispatch} todo={todo} />;
};
