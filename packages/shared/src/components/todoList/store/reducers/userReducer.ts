import { UserActionT, UserActionTypes, UserStateT } from "../../types/users";

const initialState: UserStateT = {
  users: [],
  isLoading: false,
  error: null,
};

export const userReducer = (
  state = initialState,
  action: UserActionT
): UserStateT => {
  switch (action.type) {
    case UserActionTypes.FETCH_USERS: {
      return { isLoading: true, error: null, users: [] };
    }
    case UserActionTypes.FETCH_USERS_SUCCESS: {
      return {
        error: null,
        isLoading: false,
        users: action.payload,
      };
    }
    case UserActionTypes.FETCH_USERS_ERROR: {
      return { ...state, isLoading: false, error: action.payload };
    }

    default:
      return state;
  }
};
