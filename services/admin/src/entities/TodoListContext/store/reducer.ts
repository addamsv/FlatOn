import { ActionT, TodoListStateT, actions } from "../types";

export const initialState: TodoListStateT = {
  todoList: [],
};

export const reducer = (state: TodoListStateT, action: ActionT) => {
  switch (action.type) {
    case actions.ADD_TODO_ITEM: {
      return {
        todoList: [
          ...state.todoList,
          {
            id: new Date().valueOf(),
            label: action.todoItemLabel,
            completed: false,
          },
        ],
      };
    }

    case actions.REMOVE_TODO_ITEM: {
      const filteredTodoItem = state.todoList.filter(
        (todoItem) => todoItem.id !== action.todoItemId
      );
      return { todoList: filteredTodoItem };
    }

    case actions.TOGGLE_COMPLETED: {
      const updatedTodoList = state.todoList.map((todoItem) =>
        todoItem.id === action.todoItemId
          ? { ...todoItem, completed: !todoItem.completed }
          : todoItem
      );
      return { todoList: updatedTodoList };
    }

    default:
      return state;
  }
};
