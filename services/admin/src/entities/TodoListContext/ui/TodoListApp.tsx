import { AddTodo } from "@packages/shared/src/components/AddTodo";
import { TodoList } from "@packages/shared/src/components/TodoList";
import { useTodoList } from "../store/useTodoList";

export function TodoListApp() {
  const { addTodoItem, ...props } = useTodoList();

  return (
    <div
      style={{
        border: "#aaa solid 1px",
        width: "fit-content",
        padding: 10,
        margin: 5,
      }}
    >
      <h2>Todo List Context Flux</h2>
      <AddTodo addTodoItem={addTodoItem} />
      <TodoList {...props} />
    </div>
  );
}

// https://habr.com/ru/companies/otus/articles/752824/
