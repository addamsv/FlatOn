import { createContext, useState } from "react";
import { UserT, UserContextProps } from "../types";

export type ChildPropsT = {
  children: string | JSX.Element | JSX.Element[];
};

export const UserContext = createContext<UserContextProps | undefined>(
  undefined
);

export const Provider = ({ children }: ChildPropsT) => {
  const [user, setUser] = useState<UserT | null>(null);

  return (
    <UserContext.Provider value={{ user, setUser }}>
      {children}
    </UserContext.Provider>
  );
};
