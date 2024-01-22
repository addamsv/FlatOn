import { createContext, useReducer } from "react";
import {
  addTodoAction,
  initialState,
  reducer,
  remTodoAction,
  togTodoAction,
} from "./reducer";
import { ChildPropsT } from "../types";

export const TodoListContext = createContext(undefined);

export const Provider = ({ children }: ChildPropsT) => {
  const [state, dispatch] = useReducer(reducer, undefined, () => initialState);

  const value = {
    todoList: state.todoList,

    addTodoItem: (todoItemLabel: string) => {
      dispatch(addTodoAction(todoItemLabel)); //{ type: ADD_TODO_ITEM, todoItemLabel }
    },

    removeTodoItem: (todoItemId: string) => {
      dispatch(remTodoAction(todoItemId)); //{ type: REMOVE_TODO_ITEM, todoItemId }
    },

    markAsCompleted: (todoItemId: string) => {
      dispatch(togTodoAction(todoItemId)); //{ type: TOGGLE_COMPLETED, todoItemId }
    },
  };

  return (
    <TodoListContext.Provider value={value}>
      {children}
    </TodoListContext.Provider>
  );
};
