import { Outlet } from "react-router-dom";

export default function AuthLayout() {
  return (
    <div className="py-20 flex flex-col items-center justify-center h-2/3">
      <Outlet />
    </div>
  );
}
