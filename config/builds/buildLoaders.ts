import {ModuleOptions} from "webpack";
import MiniCssExtractPlugin from "mini-css-extract-plugin";
import {BuildOptions} from "./types/types";

export default function buildLoaders ({mode}: BuildOptions): ModuleOptions["rules"] {
    const isDevMode = mode === "development";

    const cssLoader = {
        test: /\.css$/i,
        use: [
            isDevMode ? "style-loader" : MiniCssExtractPlugin.loader,
            "css-loader"
        ]
    };

    const cssModulesLoader = {
        loader: "css-loader",
        options: {
            modules: {
                localIdentName: isDevMode ? '[path][name]__[local]' : '[hash:base64:8]'
            }
        }
    };

    const scssLoader = {
        test: /\.s[ac]ss$/i,
        use: [
            isDevMode ? "style-loader" : MiniCssExtractPlugin.loader,
            // "css-loader",
            cssModulesLoader,
            "sass-loader"
        ]
    };

    const tsxLoader = {
        test: /\.tsx?$/,
        use: 'ts-loader',
        exclude: /node_modules/,
    };

    // order matter
    return [cssLoader, scssLoader, tsxLoader];
}