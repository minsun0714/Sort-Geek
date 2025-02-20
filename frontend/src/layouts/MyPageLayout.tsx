import { Outlet } from "react-router-dom";

export default function MyPageLayout() {
  return (
    <div>
      <h1>마이 페이지</h1>
      <Outlet />
    </div>
  );
}
