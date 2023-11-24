import webpack from "webpack";
import buildDevServer from "./buildDevServer";
import buildLoaders from "./buildLoaders";
import buildPlugins from "./buildPlugins";
import buildResolvers from "./buildResolvers";
import {BuildOptions} from "./types/types";

export default function buildWebpack (options: BuildOptions):  webpack.Configuration {
    const {mode, paths} = options;

    const isDevMode = mode === "development";

    return {
        mode: mode ?? 'development',

        entry: paths.entry, //path.resolve(__dirname, 'src', 'index.tsx'),

        module: {
            rules: buildLoaders(options),
        },

        resolve: buildResolvers(options),

        output: {
            path: paths.output, //path.resolve(__dirname, 'dist'),
            filename: '[name].[contenthash].js',
            clean: true
        },

        plugins: buildPlugins(options),

        devServer: isDevMode ? buildDevServer(options) : undefined,

        devtool: isDevMode && 'inline-source-map'
    };
}