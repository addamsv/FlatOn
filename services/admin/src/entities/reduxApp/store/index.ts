import { createStore, combineReducers, applyMiddleware } from "redux";
import { composeWithDevTools } from "@redux-devtools/extension";
import { thunk } from "redux-thunk";
import {
  todoListReducer,
  userReducer,
} from "@packages/shared/src/components/todoList";

export const rootReducer = combineReducers({
  user: userReducer,
  todo: todoListReducer,
});

// @ts-ignore
export const store = createStore(
  rootReducer,
  __ENV__ === "development"
    ? composeWithDevTools(applyMiddleware(thunk))
    : undefined
);
