import { create } from "zustand";

export const useSelectBoxOpenStore = create<{
  openedQueryKey: string | null;
  toggle: (id: string) => void;
}>((set) => ({
  openedQueryKey: null,
  toggle: (id) =>
    set((state) => ({
      openedQueryKey: state.openedQueryKey === id ? null : id,
    })),
}));
