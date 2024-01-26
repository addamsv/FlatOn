import { TodoListActionT, TodoListActionTypes } from "../../types/todoList";
// import axios from "axios";

export const fetchTodo = (dispatch: any, page = 1, limit = 10) => {
  dispatch({ type: TodoListActionTypes.FETCH_TODO_ITEMS });

  fetch(
    // `https://my-json-server.typicode.com/addamsv/FlatOn/posts?page=${page};limit=${limit}`

    `https://jsonplaceholder.typicode.com/todos?_page=${page};_limit=${limit}`
  )
    .then((response) => response.json())
    .then((data) =>
      setTimeout(() => {
        dispatch(
          {
            type: TodoListActionTypes.FETCH_TODO_ITEMS_SUCCESS,
            payload: data,
          },
          500
        );
      })
    )
    .catch(() => {
      dispatch({
        type: TodoListActionTypes.FETCH_TODO_ITEMS_ERROR,
        payload: "Error while loading data",
      });
    });
};

// export const fetchTodo = (page = 1, limit = 10) => {
//   return async (dispatch: any) => {
//     //Dispatch<TodoListActionT>
//     try {
//       dispatch({ type: TodoListActionTypes.FETCH_TODO_ITEMS });
//       const response = await axios.get(
//         "https://my-json-server.typicode.com/addamsv/FlatOn/posts",
//         {
//           params: { _page: page, _limit: limit },
//         }
//       );
//       setTimeout(() => {
//         dispatch({
//           type: TodoListActionTypes.FETCH_TODO_ITEMS_SUCCESS,
//           payload: response.data,
//         });
//       }, 500);
//     } catch (e) {
//       dispatch({
//         type: TodoListActionTypes.FETCH_TODO_ITEMS_ERROR,
//         payload: "Problem with loading",
//       });
//     }
//   };
// };

export const addTodoAction = (payload: string): TodoListActionT => ({
  type: TodoListActionTypes.ADD_TODO_ITEM,
  payload,
});

// export const addManyTodoAction = (payload: any): TodoListActionT => ({
//   type: TodoListActionTypes.FETCH_TODO_ITEMS_SUCCESS,
//   payload,
// });

export const remTodoAction = (payload: string): TodoListActionT => ({
  type: TodoListActionTypes.REMOVE_TODO_ITEM,
  payload,
});

export const togTodoAction = (payload: string): TodoListActionT => ({
  type: TodoListActionTypes.TOGGLE_COMPLETED,
  payload,
});

export const setTodoPageAction = (payload: number): TodoListActionT => ({
  type: TodoListActionTypes.SET_TODO_PAGE,
  payload,
});

// MocServer Guide
// https://jsonplaceholder.typicode.com/guide/
// https://jsonplaceholder.typicode.com/users/1/todos

// My own MocServer
// https://my-json-server.typicode.com/addamsv/FlatOn
// Endpoint: Posts
// https://my-json-server.typicode.com/addamsv/FlatOn/posts
// https://my-json-server.typicode.com/addamsv/FlatOn/posts/1

// https://my-json-server.typicode.com/typicode/demo
