export enum TodoListActionTypes {
  REMOVE_TODO_ITEM = "REMOVE_TODO_ITEM",
  ADD_TODO_ITEM = "ADD_TODO_ITEM",
  TOGGLE_COMPLETED = "TOGGLE_COMPLETED",
  FETCH_TODO_ITEMS = "FETCH_TODO_ITEMS",
  FETCH_TODO_ITEMS_SUCCESS = "FETCH_TODO_ITEMS_SUCCESS",
  FETCH_TODO_ITEMS_ERROR = "FETCH_TODO_ITEMS_ERROR",
  SET_TODO_PAGE = "SET_TODO_PAGE",
}

type FetchTodoListActionT = {
  type: TodoListActionTypes.FETCH_TODO_ITEMS;
};

type FetchTodoListSuccessActionT = {
  type: TodoListActionTypes.FETCH_TODO_ITEMS_SUCCESS;
  payload: TodoItemT[];
};

type FetchTodoListErrorActionT = {
  type: TodoListActionTypes.FETCH_TODO_ITEMS_ERROR;
  payload: string;
};

type SetTodoListPageActionT = {
  type: TodoListActionTypes.SET_TODO_PAGE;
  payload: number;
};

type ToggleTodoItemCompleteActionT = {
  type: TodoListActionTypes.TOGGLE_COMPLETED;
  payload: string;
};

type AddTodoItemActionT = {
  type: TodoListActionTypes.ADD_TODO_ITEM;
  payload: string;
};

type RemTodoItemActionT = {
  type: TodoListActionTypes.REMOVE_TODO_ITEM;
  payload: string;
};

export type TodoListActionT =
  | FetchTodoListActionT
  | FetchTodoListSuccessActionT
  | FetchTodoListErrorActionT
  | SetTodoListPageActionT
  | ToggleTodoItemCompleteActionT
  | AddTodoItemActionT
  | RemTodoItemActionT;

export type ActionT = {
  type: string;
  payload?: any;
};

export type TodoItemT = {
  id: string;
  title: string;
  completed: boolean;
};

export type TodoListStateT = {
  todoList: TodoItemT[];
  isLoading: boolean;
  error: string | null;
  page: number;
  limit: number;
};
