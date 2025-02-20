type ButtonProps = {
  text: string;
};
export default function Button({ text }: ButtonProps) {
  return (
    <button className="bg-blue-900 w-full p-4 rounded-md text-white">
      {text}
    </button>
  );
}
