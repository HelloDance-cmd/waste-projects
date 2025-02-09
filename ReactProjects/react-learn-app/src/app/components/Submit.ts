"use server";
import { useActionState } from "react";

const [count, formAction] = useActionState(async (state: number) => {
  await new Promise((_) => setTimeout(_, 1000));
  return state + 1;
}, 0);

export { count, formAction };
