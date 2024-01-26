import { Provider } from "react-redux";
import { TodoListHOC } from "./TodoListHOC";
import { store } from "../../store";

export const TodoListRedux = () => (
  <Provider store={store}>
    <TodoListHOC />
  </Provider>
);
