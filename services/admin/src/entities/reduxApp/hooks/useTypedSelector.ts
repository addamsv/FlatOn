import { TypedUseSelectorHook, useSelector } from "react-redux";
import { RootSateT } from "../types";

export const useTypedSelector: TypedUseSelectorHook<RootSateT> = useSelector;
