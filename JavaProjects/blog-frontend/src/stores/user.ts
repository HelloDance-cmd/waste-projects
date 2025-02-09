import { defineStore } from "pinia";
import { ref } from "vue";
import { User } from "../types/User";

export const useUserLoggingStore = defineStore("userLoggined", () => {
  const isLogin = ref<Boolean>(false);
  const setLoginStatus = (value: Boolean) => {
    isLogin.value = value;
  };
  return { isLogin, setLoginStatus };
});

export const useUser = defineStore("user", () => {
  const user = ref<User>();
  return { user };
});
