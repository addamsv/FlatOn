import { addManyTodoAction } from "../todoListReducer";

export const fetchTodo = () => {
  return (dispatch: any) =>
    fetch("https://my-json-server.typicode.com/addamsv/FlatOn/posts")
      .then((response) => response.json())
      .then((json) => dispatch(addManyTodoAction(json)));
};

// MocServer Guide
// https://jsonplaceholder.typicode.com/guide/
// https://jsonplaceholder.typicode.com/users/1/todos

// My own MocServer
// https://my-json-server.typicode.com/addamsv/FlatOn
// Endpoint: Posts
// https://my-json-server.typicode.com/addamsv/FlatOn/posts
// https://my-json-server.typicode.com/addamsv/FlatOn/posts/1
