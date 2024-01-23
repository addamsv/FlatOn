import { createContext, useReducer } from "react";
import {
  addTodoAction,
  initialState,
  todoListReducer,
  remTodoAction,
  togTodoAction,
} from "../../TodoListRedux/store/todoListReducer";
import { ChildPropsT } from "../types";

export const TodoListContext = createContext(undefined);

export const Provider = ({ children }: ChildPropsT) => {
  const [state, dispatch] = useReducer(
    todoListReducer,
    undefined,
    () => initialState
  );

  const value = {
    todoList: state.todoList,

    addTodoItem: (todoItemLabel: string) => {
      dispatch(addTodoAction(todoItemLabel));
    },

    removeTodoItem: (todoItemId: string) => {
      dispatch(remTodoAction(todoItemId));
    },

    markAsCompleted: (todoItemId: string) => {
      dispatch(togTodoAction(todoItemId));
    },
  };

  return (
    <TodoListContext.Provider value={value}>
      {children}
    </TodoListContext.Provider>
  );
};
