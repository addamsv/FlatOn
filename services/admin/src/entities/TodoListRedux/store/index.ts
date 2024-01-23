import { createStore, combineReducers, applyMiddleware } from "redux";
import cashReducer from "./cashReducer";
import { todoListReducer } from "./todoListReducer";
import { composeWithDevTools } from "@redux-devtools/extension";
import { thunk } from "redux-thunk";

const rootReducer = combineReducers({
  cash: cashReducer,
  todo: todoListReducer,
});

// @ts-ignore
export const store = createStore(
  rootReducer,
  __ENV__ === "development"
    ? composeWithDevTools(applyMiddleware(thunk))
    : undefined
);
