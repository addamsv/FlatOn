import type { Configuration as DevServerConfiguration } from 'webpack-dev-server';
import {BuildOptions} from "./types/types";

export default function buildDevServer({port}: BuildOptions): DevServerConfiguration {
    return {
        port: port ?? 5500,
        open: true,
        // just for devServer
        historyApiFallback: true
    };
}