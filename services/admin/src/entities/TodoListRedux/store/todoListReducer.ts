import { log } from "console";

type ActionT = {
  type: string;
  payload: number;
};

type StateT = {
  cash: number;
};

export type TodoItemT = {
  id: string;
  label: string;
  completed: boolean;
};

export type TodoListStateT = {
  todoList: TodoItemT[];
};

export const defaultSate: TodoListStateT = {
  todoList: [],
};

export const todoListReducer = (state = defaultSate, action: any) => {
  switch (action.type) {
    case "REMOVE_TODO_ITEM": {
      const filteredTodoItem = state.todoList.filter(
        (todoItem) => todoItem.id !== action.payload // action.todoItemId
      );
      return { todoList: filteredTodoItem };
    }

    case "ADD_TODO_ITEM": {
      return {
        todoList: [
          ...state.todoList,
          {
            id: new Date().valueOf(),
            label: action.payload, // action.todoItemLabel,
            completed: false,
          },
        ],
      };
    }

    case "TOGGLE_COMPLETED": {
      const updatedTodoList = state.todoList.map((todoItem) =>
        todoItem.id === action.payload // action.todoItemId
          ? { ...todoItem, completed: !todoItem.completed }
          : todoItem
      );
      return { todoList: updatedTodoList };
    }

    case "GET_TODO_ITEMS": {
      return { ...state, cash: 0 };
    }

    default:
      return state;
  }
};
