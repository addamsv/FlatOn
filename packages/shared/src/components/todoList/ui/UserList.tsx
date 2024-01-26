import { fetchUsers } from "../store/actionCreator/user";
import { UserStateT } from "../types/users";
import { useEffect } from "react";

export const UserList = ({
  users,
  dispatch,
}: {
  users: UserStateT;
  dispatch: any;
}) => {
  useEffect(() => {
    // dispatch(fetchUsers());
    fetchUsers(dispatch);
  }, []);

  if (users.isLoading) {
    return <h2>loading...</h2>;
  }
  if (users.error) {
    return <h2>{users.error}</h2>;
  }

  return (
    <>
      <h2>Users</h2>
      <ul>
        {users.users.length
          ? users.users.map(({ id, name }: any) => (
              <li key={id} className="userItem">
                {name}
              </li>
            ))
          : "there are not any items"}
      </ul>
    </>
  );
};
