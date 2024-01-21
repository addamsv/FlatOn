import { createStore, combineReducers } from "redux";
import cashReducer from "./cashReducer";
import { todoListReducer } from "./todoListReducer";
import { composeWithDevTools } from "@redux-devtools/extension";

const rootReducer = combineReducers({
  cash: cashReducer,
  todo: todoListReducer,
});

// @ts-ignore
export const store = createStore(rootReducer, composeWithDevTools());
