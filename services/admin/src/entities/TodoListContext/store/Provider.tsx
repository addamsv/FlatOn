import { createContext, useReducer } from "react";
import { initialState, reducer } from "./reducer";
import { ChildPropsT, actions } from "../types";

export const TodoListContext = createContext(undefined);

export const Provider = ({ children }: ChildPropsT) => {
  const [state, dispatch] = useReducer(reducer, undefined, () => initialState);

  const value = {
    todoList: state.todoList,

    addTodoItem: (todoItemLabel: string) => {
      dispatch({ type: actions.ADD_TODO_ITEM, todoItemLabel });
    },

    removeTodoItem: (todoItemId: string) => {
      dispatch({ type: actions.REMOVE_TODO_ITEM, todoItemId });
    },

    markAsCompleted: (todoItemId: string) => {
      dispatch({ type: actions.TOGGLE_COMPLETED, todoItemId });
    },
  };

  return (
    <TodoListContext.Provider value={value}>
      {children}
    </TodoListContext.Provider>
  );
};
