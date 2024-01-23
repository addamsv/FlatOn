import { Provider } from "./Provider";
import { TodoListApp } from "./TodoListApp";

export const TodoListContextFlux = () => (
  <Provider>
    <TodoListApp />
  </Provider>
);
