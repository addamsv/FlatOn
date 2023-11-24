import {ModuleOptions} from "webpack";
import MiniCssExtractPlugin from "mini-css-extract-plugin";
import {BuildOptions} from "./types/types";

export default function buildLoaders ({mode}: BuildOptions): ModuleOptions["rules"] {
    const isDevMode = mode === "development";

    return [
        // order matter
        {
            test: /\.css$/i,
            use: [
                isDevMode ? "style-loader" : MiniCssExtractPlugin.loader,
                "css-loader"
            ]
        },
        {
            test: /\.s[ac]ss$/i,
            use: [
                isDevMode ? "style-loader" : MiniCssExtractPlugin.loader,
                "css-loader",
                "sass-loader"
            ]
        },
        {
            test: /\.tsx?$/,
            use: 'ts-loader',
            exclude: /node_modules/,
        },
    ];
}