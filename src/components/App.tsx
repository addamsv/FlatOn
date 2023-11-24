import classes from "./App.module.scss";
import {useState} from "react";
import {Link, Outlet} from "react-router-dom";

export const App = () => {
    const [value, setValue] = useState(0);

    const inc = () => setValue((prev) => prev + 1);

    return (
        <div>
            <h1>The Flat On App</h1>
            <Link to={'/'}>main</Link>
            <br/>
            <Link to={'/about'}>about</Link>
            <br/>
            <Link to={'/shop'}>shop</Link>
            <p className={classes.paragraph}>ver: {ENV_VERSION}</p>
            <span>{value}</span>
            <button
                className="button"
                onClick={inc}
            >
                add
            </button>
            <Outlet/>
        </div>
    );
};
