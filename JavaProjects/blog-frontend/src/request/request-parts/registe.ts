import { AxiosRequestConfig } from "axios";
import { Response, ins } from "..";
import { User } from "../../types/User";

/**
 * 注册一个账号以Post方式
 * @param user
 * @param config
 * @returns
 */
export const registerPost = (
  user: User,
  config?: AxiosRequestConfig
): Response<string> => {
  return ins.post(
    "/api/users/register",
    {
      user,
    },
    config
  );
};
