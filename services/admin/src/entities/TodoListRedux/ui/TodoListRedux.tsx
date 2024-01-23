import { Provider } from "react-redux";
import { store } from "../store";
import { TodoListHOC } from "./TodoListHOC";

export const TodoListRedux = () => (
  <Provider store={store}>
    <TodoListHOC />
  </Provider>
);
