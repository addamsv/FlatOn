export type TodoItemT = {
  id: string;
  label: string;
  completed: boolean;
};

export type PropsT = {
  todoList: TodoItemT[];
  removeTodoItem: (id: string) => void;
  markAsCompleted: (id: string) => void;
};

export const TodoList = (props: PropsT) => {
  const { todoList, removeTodoItem, markAsCompleted } = props;

  return (
    <ul>
      {todoList.length
        ? todoList.map(({ completed, id, label }: TodoItemT) => (
            <li
              key={id}
              onClick={() => markAsCompleted(id)}
              className={`todoItem ${completed ? "completed" : ""}`}
            >
              {label}
              <button className="delete" onClick={() => removeTodoItem(id)}>
                X
              </button>
            </li>
          ))
        : "there are not any items"}
    </ul>
  );
};
