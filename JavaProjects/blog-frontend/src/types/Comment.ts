import { User } from "./User";
import { v4 as uuid } from "uuid";
import { useUser } from "../stores/user";

export interface Comment {
  id: string;
  articleId: string;
  userId: number;
  commentContent: string;
  commentTime: number;
  user: User;
}

export function commentCreator(user: User) {
  return {  }
}

