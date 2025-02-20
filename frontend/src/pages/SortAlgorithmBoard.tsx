import SelectBox from "../components/common/SelectBox";

export default function SortAlgorithmBoard() {
  return (
    <div className="flex flex-col items-center justify-center w-2/3 border border-red-500 h-2/3">
      <h1 className="text-left text-3xl font-semibold w-full">
        정렬 알고리즘 조회
      </h1>
      <section className="flex justify-start w-full gap-4">
        <SelectBox
          queryKey="language"
          value="언어"
          items={[
            { id: 0, name: "C++" },
            { id: 1, name: "Java" },
            { id: 2, name: "Python" },
            { id: 3, name: "JavaScript" },
          ]}
        />
        <SelectBox
          queryKey="sort"
          value="최신순"
          items={[
            { id: 0, name: "최신순" },
            { id: 1, name: "인기순" },
          ]}
        />
        <SelectBox
          queryKey="count"
          value="5개씩 보기"
          items={[
            { id: 0, name: "5개씩 보기" },
            { id: 1, name: "10개씩 보기" },
          ]}
        />
      </section>
    </div>
  );
}
