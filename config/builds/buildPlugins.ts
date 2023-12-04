import webpack, {Configuration} from "webpack";
import HtmlWebpackPlugin from "html-webpack-plugin";
import MiniCssExtractPlugin from "mini-css-extract-plugin";
import {BuildOptions} from "./types/types";
import {BundleAnalyzerPlugin} from "webpack-bundle-analyzer";
import ForkTsCheckerWebpackPlugin from "fork-ts-checker-webpack-plugin";
import ReactRefreshPlugin from "@pmmmwh/react-refresh-webpack-plugin";

export default function buildPlugins({mode, paths, analyzer}: BuildOptions): Configuration["plugins"] {
    const isDevMode = mode === "development";

    const isProdMode = mode === "production";

    const plugins: Configuration["plugins"] = [
        new  HtmlWebpackPlugin({
            template: paths.html //path.resolve(__dirname, 'public', 'index.html'),
        }),

        new webpack.DefinePlugin({
            /* dont forget to add into the global.d.ts */
            ENV_SERVER_PATH: JSON.stringify(isDevMode ? 'localhost' : '<real_URL>'),
            // ENV_BASE_URL: JSON.stringify('localhost'),
            ENV_VERSION: JSON.stringify('5fa3b9'),
            //     PRODUCTION: JSON.stringify(!isDevMode),
            //     // BROWSER_SUPPORTS_HTML5: true,
            //     // TWO: '1+1',
            //     // 'typeof window': JSON.stringify('object'),
        })
    ]

    if (isDevMode) {
        plugins.push(new webpack.ProgressPlugin());

        plugins.push(new ForkTsCheckerWebpackPlugin());

        plugins.push(new ReactRefreshPlugin());
    }

    if (isProdMode) {
        plugins.push(new MiniCssExtractPlugin({
            filename: 'css/[name].[contenthash:8].css',
            chunkFilename: 'css/[name].[contenthash:8].css',
        }));
    }

    if (analyzer) {
        plugins.push(new BundleAnalyzerPlugin());
    }

    return plugins;
}