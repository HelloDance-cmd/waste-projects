import { AxiosRequestConfig } from "axios";
import { Response, ins } from "..";
import { User } from "../../types/User";

/**
 * 用户登录
 * @param userName 用户名
 * @param password 密码
 * @param config
 * @returns
 */
export const userLoggined = (
  userName: string,
  password: string,
  config?: AxiosRequestConfig
): Response<User | null> => {
  return ins.post(
    "/api/users/login",
    {
      username: userName,
      password,
    },
    config
  );
};
