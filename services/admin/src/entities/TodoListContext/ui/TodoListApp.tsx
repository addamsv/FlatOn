import { AddTodo } from "@packages/shared/src/components/AddTodo";
import { TodoList } from "@packages/shared/src/components/TodoList";
import { useTodoList } from "../store/useTodoList";

export function TodoListApp() {
  const { addTodoItem, ...props } = useTodoList();

  return (
    <div>
      <h2>Todo List Context Flux</h2>
      <AddTodo addTodoItem={addTodoItem} />
      <TodoList {...props} />
    </div>
  );
}

// https://habr.com/ru/companies/otus/articles/752824/
