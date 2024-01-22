import { ActionT, TodoListStateT } from "../types";

export const initialState: TodoListStateT = {
  todoList: [],
};

const REMOVE_TODO_ITEM = "REMOVE_TODO_ITEM";
const ADD_TODO_ITEM = "ADD_TODO_ITEM";
const TOGGLE_COMPLETED = "TOGGLE_COMPLETED";

export const addTodoAction = (payload: string) => ({
  type: ADD_TODO_ITEM,
  payload,
});

export const remTodoAction = (payload: string) => ({
  type: REMOVE_TODO_ITEM,
  payload,
});

export const togTodoAction = (payload: string) => ({
  type: TOGGLE_COMPLETED,
  payload,
});

export const reducer = (state: TodoListStateT, action: any) => {
  const { type, payload } = action;
  switch (type) {
    case ADD_TODO_ITEM: {
      return {
        todoList: [
          ...state.todoList,
          {
            id: new Date().valueOf(),
            label: payload,
            completed: false,
          },
        ],
      };
    }

    case REMOVE_TODO_ITEM: {
      const filteredTodoItem = state.todoList.filter(
        (todoItem) => todoItem.id !== payload
      );
      return { todoList: filteredTodoItem };
    }

    case TOGGLE_COMPLETED: {
      const updatedTodoList = state.todoList.map((todoItem) =>
        todoItem.id === payload
          ? { ...todoItem, completed: !todoItem.completed }
          : todoItem
      );
      return { todoList: updatedTodoList };
    }

    default:
      return state;
  }
};
