import { useState } from "react";

type AddTodoItemT = {
  addTodoItem: (todoItemLabel: string) => void;
};

export const AddTodo = ({ addTodoItem }: AddTodoItemT) => {
  const [inputValue, setInputValue] = useState("");

  const setValueHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(e.target.value);
  };

  const addValueHandler = () => {
    addTodoItem(inputValue);
    setInputValue("");
  };

  return (
    <>
      <input
        type="text"
        value={inputValue}
        placeholder={"Type and add todo item"}
        onChange={setValueHandler}
      />
      <button onClick={addValueHandler}>Add</button>
    </>
  );
};
