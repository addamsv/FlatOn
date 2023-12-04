/**
 * @link https://webpack.js.org
 */

import path from 'path';
import webpack from 'webpack';
import buildWebpack from "./config/builds/buildWebpack";
import {BuildMode} from "./config/builds/types/types";

interface EnvVar{
    MODE?: BuildMode;
    PORT?: number;
    ANALYZER?: boolean;
    BASE_URL?: string;
}
export default (env: EnvVar): webpack.Configuration =>  {
    return  buildWebpack({
        port: env.PORT ?? 5500,
        mode: env.MODE ?? "development",
        paths: {
            output: path.resolve(__dirname, 'dist'),
            entry: path.resolve(__dirname, 'src', 'index.tsx'),
            html: path.resolve(__dirname, 'public', 'index.html'),
            public: path.resolve(__dirname, 'public'),
            src: path.resolve(__dirname, 'src'),
        },
        analyzer: env.ANALYZER
    });
}