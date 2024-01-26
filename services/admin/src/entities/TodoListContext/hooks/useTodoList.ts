import { useContext } from "react";
import { TodoListContext } from "../store/Provider";

export const useTodoList = () => {
  const context = useContext(TodoListContext);

  if (!context) {
    throw new Error("useTodoList must be used within a Provider");
  }

  return context;
};
