export enum UserActionTypes {
  FETCH_USERS = "FETCH_USERS",
  FETCH_USERS_SUCCESS = "FETCH_USERS_SUCCESS",
  FETCH_USERS_ERROR = "FETCH_USERS_ERROR",
}

export type UserStateT = {
  users: any[];
  isLoading: boolean;
  error: null | string;
};

type FetchUserActionT = {
  type: UserActionTypes.FETCH_USERS;
};

type FetchUserSuccessActionT = {
  type: UserActionTypes.FETCH_USERS_SUCCESS;
  payload: any[];
};

type FetchUserErrorActionT = {
  type: UserActionTypes.FETCH_USERS_ERROR;
  payload: string;
};

export type UserActionT =
  | FetchUserActionT
  | FetchUserSuccessActionT
  | FetchUserErrorActionT;
