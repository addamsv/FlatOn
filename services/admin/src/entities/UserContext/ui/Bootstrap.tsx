import { Provider } from "../store/Provider";
import { User } from "./User";

export const UserContext = () => (
  <Provider>
    <User />
  </Provider>
);
