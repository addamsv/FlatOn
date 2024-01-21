type ActionT = {
  type: string;
  payload: number;
};

type StateT = {
  cash: number;
};

const defaultSate: StateT = {
  cash: 0,
};

const cashReducer = (state = defaultSate, action: ActionT) => {
  switch (action.type) {
    case "ADD_CASH": {
      return { ...state, cash: state.cash + action.payload };
    }

    case "GET_CASH": {
      return { ...state, cash: state.cash - action.payload };
    }

    default:
      return state;
  }
};

export default cashReducer;
