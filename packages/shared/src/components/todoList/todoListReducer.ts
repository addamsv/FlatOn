type ActionT = {
  type: string;
  payload: any; // string;
};

export type TodoItemT = {
  id: string;
  label: string;
  completed: boolean;
};

export type TodoListStateT = {
  todoList: TodoItemT[];
};

export const initialState: TodoListStateT = {
  todoList: [],
};

const REMOVE_TODO_ITEM = "REMOVE_TODO_ITEM";
const ADD_TODO_ITEM = "ADD_TODO_ITEM";
const ADD_MANY_TODO_ITEMS = "ADD_MANY_TODO_ITEMS";
const TOGGLE_COMPLETED = "TOGGLE_COMPLETED";

export const addTodoAction = (payload: string) => ({
  type: ADD_TODO_ITEM,
  payload,
});

export const addManyTodoAction = (payload: any) => ({
  type: ADD_MANY_TODO_ITEMS,
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

export const todoListReducer = (state = initialState, action: ActionT) => {
  const { payload, type } = action;

  switch (type) {
    case ADD_MANY_TODO_ITEMS: {
      return {
        todoList: [...state.todoList, ...payload],
      };
    }

    case REMOVE_TODO_ITEM: {
      const filteredTodoItem = state.todoList.filter(
        (todoItem) => todoItem.id !== payload
      );
      return { todoList: filteredTodoItem };
    }

    case ADD_TODO_ITEM: {
      return {
        todoList: [
          ...state.todoList,
          {
            id: Date.now(),
            label: payload,
            completed: false,
          },
        ],
      };
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
