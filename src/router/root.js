import { Suspense, lazy } from "react";
import todoRouter from "./todoRouter";
import storeRouter from "./storeRouter";
import productRouter from "./productRouter";

const { createBrowserRouter } = require("react-router-dom");

const Loading = <div>Loading...</div>
const Main = lazy(() => import("../pages/MainPage"));
const About = lazy(() => import("../pages/AboutPage"));
const TodoIndex = lazy(() => import("../pages/todo/IndexPage"));
const StoreIndex = lazy(() => import("../pages/store/IndexPage"));
const ProductIndex = lazy(() => import("../pages/products/IndexPage"));

const root = createBrowserRouter([
    {
        path: "",
        element: <Suspense fallback={Loading}><Main /></Suspense>,
    },
    {
        path: "about",
        element: <Suspense fallback={Loading}><About /></Suspense>,
    },
    {
        path: "todo",
        element: <Suspense fallback={Loading}><TodoIndex /></Suspense>,
        children: todoRouter()      
    },
    {
        path: "store",
        element: <Suspense fallback={Loading}><StoreIndex /></Suspense>,
        children: storeRouter()
    },
    {
        path: "products",
        element: <Suspense fallback={Loading}><ProductIndex /></Suspense>,
        children: productRouter()
    }

])

export default root;
