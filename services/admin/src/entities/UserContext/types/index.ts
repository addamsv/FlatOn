export interface UserContextProps {
  user: UserT | null;
  setUser: React.Dispatch<React.SetStateAction<UserT | null>>;
}

export interface UserT {
  name: string;
  age: number;
}
