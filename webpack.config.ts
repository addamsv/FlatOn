/**
 * @link https://webpack.js.org
 */

import path from 'path';
import HtmlWebpackPlugin from 'html-webpack-plugin';
import webpack from 'webpack';
import type { Configuration as DevServerCConfiguration } from 'webpack-dev-server';
import MiniCssExtractPlugin from "mini-css-extract-plugin";

type Mode = "production" | "development";

interface EnvVar{
    MODE: Mode;
    PORT: number;
}
export default (env: EnvVar) =>  {
    const isDevMode = env.MODE === 'development';

    const config: webpack.Configuration = {
        mode: env.MODE ?? 'development',

        entry: path.resolve(__dirname, 'src', 'index.tsx'),

        module: {
            rules: [
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
            ],
        },

        resolve: {
            extensions: ['.tsx', '.ts', '.js'],
        },

        output: {
            path: path.resolve(__dirname, 'dist'),
                filename: '[name].[contenthash].js',
                clean: true
        },

        plugins: [
            new  HtmlWebpackPlugin({
                template: path.resolve(__dirname, 'public', 'index.html'),
            }),

            new webpack.ProgressPlugin(),

            !isDevMode && new MiniCssExtractPlugin({
                filename: 'css/[name].[contenthash:8].css',
                chunkFilename: 'css/[name].[contenthash:8].css',
            })
        ].filter(Boolean),

        devServer: isDevMode ? {
            port: env.PORT ?? 5500,
            open: true
        } : undefined,

        devtool: isDevMode && 'inline-source-map'
    }

    return config;
}