import { useForm } from "react-hook-form";
import Button from "../components/auth/Button";

type LoginFormData = {
  id: string;
  password: string;
};

export default function Register() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<LoginFormData>();
  const onSubmit = (data: LoginFormData) => console.log(data);
  return (
    <div className="flex flex-col items-center justify-center w-1/4 h-2/3">
      <h1 className="text-left text-3xl font-semibold w-full">회원가입</h1>
      <form
        onSubmit={handleSubmit(onSubmit)}
        className="flex flex-col items-center justify-center h-2/3 w-full my-6"
      >
        <label className="py-2 w-full">아이디</label>
        <input
          {...register("id", { required: true })}
          className="h-10 p-2 w-full border-2 border-blue-900 outline-none"
        />
        {errors.id ? (
          <p className="text-red-600 text-left w-full">아이디를 입력해주세요</p>
        ) : (
          <div className="h-6" />
        )}
        <label className="py-2 w-full">비밀번호</label>
        <input
          type="password"
          {...register("password", { required: true })}
          className="h-10 p-2 w-full border-2 border-blue-900 outline-none"
        />
        {errors.password ? (
          <p className="text-red-600 text-left w-full">
            비밀번호를 입력해주세요
          </p>
        ) : (
          <div className="h-6" />
        )}

        <label className="py-2 w-full">비밀번호 확인</label>
        <input
          type="password"
          {...register("password", { required: true })}
          className="h-10 p-2 w-full border-2 border-blue-900 outline-none"
        />
        {errors.password ? (
          <p className="text-red-600 text-left w-full">
            비밀번호를 한 번 더 입력해주세요
          </p>
        ) : (
          <div className="h-6" />
        )}

        <div className="w-full py-4">
          <Button text="회원가입" />
        </div>
      </form>
    </div>
  );
}
