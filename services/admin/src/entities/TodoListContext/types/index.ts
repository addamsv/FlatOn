export type TodoItemT = {
  id: string;
  label: string;
  completed: boolean;
};

export type TodoListStateT = {
  todoList: TodoItemT[];
};

export type ActionT = {
  type: string;
  todoItemLabel?: string;
  todoItemId?: string;
};

export type ChildPropsT = {
  children: string | JSX.Element | JSX.Element[];
};
