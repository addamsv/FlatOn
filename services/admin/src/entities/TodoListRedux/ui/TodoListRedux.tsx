import { Provider } from "react-redux";
import { TodoListApp } from "./TodoListApp";
import { store } from "../store/rootReducer";

export const TodoListRedux = () => (
  <Provider store={store}>
    <TodoListApp />
  </Provider>
);
