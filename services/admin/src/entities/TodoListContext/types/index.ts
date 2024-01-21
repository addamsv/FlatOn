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

export const actions = {
  ADD_TODO_ITEM: "ADD_TODO ITEM",
  REMOVE_TODO_ITEM: "REMOVE_TODO_ITEM",
  TOGGLE_COMPLETED: "TOGGLE_COMPLETED",
};

export type ChildPropsT = {
  children: string | JSX.Element | JSX.Element[];
};

// export type UserContextProps = {
//   todoList: TodoListStateT | null;
//   setList: React.Dispatch<React.SetStateAction<TodoListStateT[] | null>>;
// }
