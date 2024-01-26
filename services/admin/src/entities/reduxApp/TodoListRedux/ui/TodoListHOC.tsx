import { useDispatch } from "react-redux";
import { TodoListApp } from "@packages/shared/src/components/todoList";
import { useTypedSelector } from "../../hooks/useTypedSelector";
import { useActions } from "../../hooks/useActions";

export const TodoListHOC = () => {
  const todo = useTypedSelector((state) => state.todo);
  const users = useTypedSelector((state) => state.user);
  const dispatch = useDispatch();
  const { fetchUsers } = useActions();

  return <TodoListApp dispatch={dispatch} todo={todo} users={users} />;
};
