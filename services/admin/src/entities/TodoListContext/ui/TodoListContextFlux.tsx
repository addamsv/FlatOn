import { Provider } from "../store/Provider";
import { TodoListApp } from "./TodoListApp";

export const TodoListContextFlux = () => (
  <Provider>
    <TodoListApp />
  </Provider>
);
