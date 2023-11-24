import {Configuration} from "webpack";
import {BuildOptions} from "./types/types";

export default function buildResolvers(options: BuildOptions): Configuration["resolve"] {
    return {
        extensions: ['.tsx', '.ts', '.js'],
    }
}