import { UserCard } from "@packages/shared/src/components/UserCard";
import { useUser } from "@/entities/UserContext/store/useUser";
import { UserT } from "../types";

export const User = () => {
  const { user, setUser } = useUser();

  const handleLogin = () => {
    setUser((user: UserT) => ({ name: "John", age: user ? user.age + 1 : 30 }));
  };

  return (
    <div>
      <UserCard
        username={user ? user.name : ""}
        password={user ? String(user.age) : ""}
      />
      <button onClick={handleLogin}>Check</button>
    </div>
  );
};
