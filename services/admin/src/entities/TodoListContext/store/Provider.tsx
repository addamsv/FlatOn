import { createContext, useReducer } from "react";
import {
  initialTodoListState,
  todoListReducer,
} from "@packages/shared/src/components/todoList";
import { ProviderT } from "../types";

export const TodoListContext = createContext(undefined);

export const Provider = (props: ProviderT) => {
  const [todo, dispatch] = useReducer(
    todoListReducer,
    undefined,
    () => initialTodoListState
  );

  const value = {
    todo,
    dispatch,
  };

  return (
    <TodoListContext.Provider value={value}>
      {props.children}
    </TodoListContext.Provider>
  );
};
