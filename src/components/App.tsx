import classes from "./App.module.scss";
import {useState} from "react";
import {Link, Outlet} from "react-router-dom";
import gitImg from "@/assets/githublogo.png";
import phoneImg from "@/assets/phoneImg.jpg";
import Like from "@/assets/like.svg";

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
            <div className={classes.btn} onClick={inc}>
                <Like width={50} height={50} fill={'red'} />
            </div>
            <Outlet/>
            <br/>
            <img src={gitImg} alt='Git Img' width={150} height={150} />
            <br/>
            <img src={phoneImg} alt='Phone Img' width={150} height={250} />
        </div>
    );
};
