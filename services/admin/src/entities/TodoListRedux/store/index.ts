import { createStore, combineReducers, applyMiddleware } from "redux";
import { composeWithDevTools } from "@redux-devtools/extension";
import { thunk } from "redux-thunk";
import { todoListReducer } from "@packages/shared/src/components/todoList/todoListReducer";

const rootReducer = combineReducers({
  // cash: cashReducer,
  todo: todoListReducer,
});

// @ts-ignore
export const store = createStore(
  rootReducer,
  __ENV__ === "development"
    ? composeWithDevTools(applyMiddleware(thunk))
    : undefined
);
