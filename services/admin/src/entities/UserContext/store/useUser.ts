import { useContext } from "react";
import { UserContext } from "./Provider";

export const useUser = () => {
  const context = useContext(UserContext);

  if (!context) {
    throw new Error("useUser must be used within a Provider");
  }

  return context;
};
