import {
  TodoListActionT,
  TodoListActionTypes,
  TodoListStateT,
} from "../../types/todoList";

export const initialTodoListState: TodoListStateT = {
  todoList: [],
  isLoading: false,
  error: null,
  limit: 10,
  page: 1,
};

export const todoListReducer = (
  state = initialTodoListState,
  action: TodoListActionT
): TodoListStateT => {
  switch (action.type) {
    case TodoListActionTypes.FETCH_TODO_ITEMS: {
      return {
        ...state,
        isLoading: true,
        error: null,
        todoList: [...state.todoList],
      };
    }
    case TodoListActionTypes.FETCH_TODO_ITEMS_SUCCESS: {
      return {
        ...state,
        isLoading: false,
        error: null,
        todoList: [...action.payload], //...state.todoList,
      };
    }
    case TodoListActionTypes.FETCH_TODO_ITEMS_ERROR: {
      return { ...state, isLoading: false, error: action.payload };
    }

    case TodoListActionTypes.REMOVE_TODO_ITEM: {
      const filteredTodoItem = state.todoList.filter(
        (todoItem) => todoItem.id !== action.payload
      );
      return { ...state, todoList: filteredTodoItem };
    }

    case TodoListActionTypes.ADD_TODO_ITEM: {
      return {
        ...state,
        todoList: [
          ...state.todoList,
          {
            id: String(Date.now()),
            title: action.payload,
            completed: false,
          },
        ],
      };
    }

    case TodoListActionTypes.SET_TODO_PAGE: {
      return { ...state, page: action.payload };
    }

    case TodoListActionTypes.TOGGLE_COMPLETED: {
      const updatedTodoList = state.todoList.map((todoItem) =>
        todoItem.id === action.payload
          ? { ...todoItem, completed: !todoItem.completed }
          : todoItem
      );
      return { ...state, todoList: updatedTodoList };
    }

    default:
      return state;
  }
};
