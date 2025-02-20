import { NavLink } from "react-router";

export default function Header() {
  return (
    <header className="flex justify-around items-center p-4 text-black border-b border-gray-100 sticky top-0 bg-white z-50">
      <NavLink to="/" end className={"flex items-center gap-2"}>
        <img src="/logo.svg" alt="logo" />
        Sort Geek
      </NavLink>
      <nav className="flex gap-12">
        <NavLink to="/board" end>
          정렬 알고리즘 조회
        </NavLink>
        <NavLink to="/practice">연습하기</NavLink>
        <NavLink to="/login">로그인</NavLink>
      </nav>
    </header>
  );
}
