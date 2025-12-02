import { Suspense, lazy } from "react";
import { Navigate } from "react-router-dom";

const Loading = <div>Loading...</div>
const StoreBuy = lazy(() => import("../pages/store/BuyPage"));
const StoreSell = lazy(() => import("../pages/store/SellPage"));

const todoRouter = () => {
    return [
        {
            path: "buy",
            element: <Suspense fallback={Loading}><StoreBuy /></Suspense>,
        },
        {
            path: "sell",
            element: <Suspense fallback={Loading}><StoreSell /></Suspense>,
        },
    ]
}
export default todoRouter;
