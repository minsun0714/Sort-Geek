import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.tsx";
import { BrowserRouter, Routes, Route } from "react-router";
import Header from "./components/common/Header.tsx";
import Login from "./pages/Login.tsx";
import AuthLayout from "./layouts/AuthLayout.tsx";
import MyPageLayout from "./layouts/MyPageLayout.tsx";
import SortAlgorithmBoard from "./pages/SortAlgorithmBoard.tsx";
import SortAlgorithmDetail from "./pages/SortAlgorithmDetail.tsx";
import MyCodeList from "./pages/MyCodeList.tsx";
import Register from "./pages/Register.tsx";
import SortAlgorithmPractice from "./pages/SortAlgorithmPractice.tsx";
import ExecutionResult from "./pages/ExecutionResult.tsx";
import TestCase from "./pages/TestCase.tsx";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <BrowserRouter>
      <Header />
      <Routes>
        <Route index element={<App />} />

        <Route element={<AuthLayout />}>
          <Route path="login" element={<Login />} />
          <Route path="register" element={<Register />} />
        </Route>

        <Route path="mypage" element={<MyPageLayout />}>
          <Route index path="codelist" element={<MyCodeList />} />
        </Route>

        <Route path="board" element={<SortAlgorithmBoard />}>
          <Route path=":id" element={<SortAlgorithmDetail />} />
        </Route>
        <Route path="practice" element={<SortAlgorithmPractice />}>
          <Route path="execution-result" element={<ExecutionResult />} />
          <Route path="testcase" element={<TestCase />} />
        </Route>
        <Route path="login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  </StrictMode>
);
