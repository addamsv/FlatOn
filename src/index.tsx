import {createRoot} from "react-dom/client";
import {App} from "./components/App";
import "./index.css";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import {AboutLazy} from "./pages/about/About.lazy";
import {ShopLazy} from "@/pages/shop/Shop.lazy";
import {Suspense} from "react";

const root = document.getElementById('root');

if (!root) { throw new Error('root not found') }

const container = createRoot(root);

const router = createBrowserRouter([
    {
        path: '/',
        element: <App/>,
        children: [
            {path: '/about', element: <Suspense fallback={'loading...'}><AboutLazy /></Suspense>},
            {path: '/shop', element: <Suspense fallback={'loading...'}><ShopLazy /></Suspense>},
        ]
    }

]);

container.render(<RouterProvider router={router} />);