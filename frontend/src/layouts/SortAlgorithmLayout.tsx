import { Outlet } from "react-router-dom";

export default function SortAlgorithmLayout() {
  return (
    <div className="py-20 flex flex-col items-center justify-center w-full">
      <Outlet />
    </div>
  );
}
