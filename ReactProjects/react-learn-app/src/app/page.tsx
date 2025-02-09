"use client";

import { useFormStatus } from "react-dom";
import { count, formAction } from "./components/Submit";

export default function Home() {
  return (
    <form action={formAction} method="post">
      <SubmitButton count={count} />
    </form>
  );
}

function SubmitButton({ count }: { count: number }) {
  const { pending, data } = useFormStatus();

  return (
    <button type="submit" disabled={pending}>
      提交 {count}
    </button>
  );
}
