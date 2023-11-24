import classes from "./App.module.scss";
import {useState} from "react";

export const App = () => {
    const [value, setValue] = useState(0);

    const inc = () => setValue((prev) => prev + 1);

    return (
        <div>
            <h1>The Flat On App</h1>
            <p className={classes.paragraph}>ver: {ENV_VERSION}</p>
            <span>{value}</span>
            <button
                className="button"
                onClick={inc}
            >
                add
            </button>
        </div>
    );
};
