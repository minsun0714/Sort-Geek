import { useSearchParams } from "react-router-dom";
import { useSelectBoxOpenStore } from "../../store/selectBoxOpen";

type SelectBoxProps = {
  queryKey: string;
  value: string;
  items: { id: number; name: string }[];
};

export default function SelectBox({ queryKey, value, items }: SelectBoxProps) {
  const { openedQueryKey, toggle } = useSelectBoxOpenStore();
  const [searchParams, setSearchParams] = useSearchParams();

  const selectValue = (id: number) => {
    searchParams.set(queryKey, id.toString());
    setSearchParams(searchParams);
    toggle(queryKey);
  };

  return (
    <div className="relative">
      <button
        onClick={() => toggle(queryKey)}
        className="flex h-full justify-between itemss-center p-2 w-36 text-left border-2 rounded-md"
      >
        <label className="h-full flex items-center">
          {items.find((item) => item.id === Number(searchParams.get(queryKey)))
            ?.name || value}
        </label>
        <img
          src="/dropdown-arrow.svg"
          alt="arrow-down"
          className="w-4 h-full"
        />
      </button>
      {openedQueryKey === queryKey && (
        <ul className="absolute left-0 w-36 bg-white border rounded-md mt-1 shadow-md">
          {items.map((item) => {
            return (
              <li key={item.id} className="hover:bg-gray-200">
                <button
                  onClick={() => selectValue(item.id)}
                  className="w-full text-left p-2"
                >
                  {item.name}
                </button>
              </li>
            );
          })}
        </ul>
      )}
    </div>
  );
}
