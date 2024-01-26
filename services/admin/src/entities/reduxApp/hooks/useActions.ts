import { useDispatch } from "react-redux";
import { bindActionCreators } from "redux";
import * as UserActionCreators from "@packages/shared/src/components/todoList/store/actionCreator/user";

export const useActions = () => {
  const dispatch = useDispatch();
  return bindActionCreators(UserActionCreators, dispatch);
};
