import { Outlet } from "react-router-dom";
import { deepMerge } from "@packages/shared/src/utils/deepMerge";
import { UserContext } from "@/entities/UserContext";
import { TodoListContextFlux } from "@/entities/TodoListContext";
import { TodoListRedux } from "@/entities/TodoListRedux";

export const App = () => {
  deepMerge();

  return (
    <div>
      <h1>ADMIN MODULE</h1>
      <Outlet />
      <UserContext />
      <TodoListContextFlux />
      <TodoListRedux />
    </div>
  );
};
