import { Provider } from "../store/Provider";
import { TodoListHOC } from "./TodoListHOC";

export const TodoListContextFlux = () => (
  <Provider>
    <TodoListHOC />
  </Provider>
);
