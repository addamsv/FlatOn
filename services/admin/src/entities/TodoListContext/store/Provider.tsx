import { ReactNode, createContext, useReducer } from "react";
import {
  initialState,
  todoListReducer,
} from "@packages/shared/src/components/todoList";

export const TodoListContext = createContext(undefined);

type ProviderT = {
  children: ReactNode;
};

export const Provider = (props: ProviderT) => {
  const [state, dispatch] = useReducer(
    todoListReducer,
    undefined,
    () => initialState
  );

  const value = {
    todoList: state.todoList,
    dispatch,
  };

  return (
    <TodoListContext.Provider value={value}>
      {props.children}
    </TodoListContext.Provider>
  );
};
