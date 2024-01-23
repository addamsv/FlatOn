import { addManyTodoAction } from "@/entities/TodoListRedux/store/todoListReducer";

export const fetchTodo = () => {
  return (dispatch: any) =>
    fetch("https://my-json-server.typicode.com/addamsv/FlatOn/posts")
      .then((response) => response.json())
      .then((json) => dispatch(addManyTodoAction(json)));
};

// https://jsonplaceholder.typicode.com

// Server
// https://my-json-server.typicode.com/addamsv/FlatOn

// Endpoint: Posts
// https://my-json-server.typicode.com/addamsv/FlatOn/posts
// https://my-json-server.typicode.com/addamsv/FlatOn/posts/1

// https://jsonplaceholder.typicode.com/users/1/todos
