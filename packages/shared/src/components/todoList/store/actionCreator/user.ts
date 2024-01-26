import { UserActionTypes, UserActionT } from "../../types/users";
// import { Dispatch } from "redux";
// import axios from "axios";

// export const fetchUsers = () => {
//   return async (dispatch: Dispatch<UserActionT>) => {
//     try {
//       dispatch({ type: UserActionTypes.FETCH_USERS });
//       const response = await axios.get(
//         "https://my-json-server.typicode.com/addamsv/FlatOn/users"
//         // "https://jsonplaceholder.typicode.com/users/"
//       );
//       setTimeout(() => {
//         dispatch({
//           type: UserActionTypes.FETCH_USERS_SUCCESS,
//           payload: response.data,
//         });
//       }, 500);
//     } catch (e) {
//       dispatch({
//         type: UserActionTypes.FETCH_USERS_ERROR,
//         payload: "Problem with loading Users",
//       });
//     }
//   };
// };

export const fetchUsers = (dispatch: any, page = 1, limit = 10) => {
  dispatch({ type: UserActionTypes.FETCH_USERS });

  fetch(
    `https://my-json-server.typicode.com/addamsv/FlatOn/users?page=${page};limit=${limit}`

    // "https://jsonplaceholder.typicode.com/users/"
  )
    .then((response) => response.json())
    .then((data) =>
      setTimeout(() => {
        dispatch(
          {
            type: UserActionTypes.FETCH_USERS_SUCCESS,
            payload: data,
          },
          500
        );
      })
    )
    .catch(() => {
      dispatch({
        type: UserActionTypes.FETCH_USERS_ERROR,
        payload: "Error while loading data",
      });
    });
};
