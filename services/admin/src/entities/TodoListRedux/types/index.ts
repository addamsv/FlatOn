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
