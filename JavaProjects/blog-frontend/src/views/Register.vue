<template>
  <div class="register-container">
    <h2 class="text-[230%]">注册</h2>
    <VaForm
      ref="registerForm"
      stateful
      class="mb-2 flex flex-col gap-2"
      @submit.prevent="register"
    >
      <VaInput
        required-mark
        name="username"
        label="用户名"
        v-model="username"
      />
      <VaInput required-mark name="password" label="密码" v-model="password" />
      <VaInput
        required-mark
        name="confirm-password"
        label="密码"
        v-model="confirmPassword"
      />
      <VaInput name="email" label="邮箱(可选)" v-model="email" />
      <VaButton type="submit">注册</VaButton>
    </VaForm>
  </div>
</template>

<script setup lang="ts">
import { registerPost } from "../request";
import { type User } from "../types/User";
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useToast } from "vuestic-ui/web-components";

const toast = useToast();

const username = ref<string>("");
const password = ref<string>("");
const confirmPassword = ref<string>("");
const email = ref<string>("");

const router = useRouter();

const register = async () => {
  const data: User = {
    id: +new Date(),
    username: username.value,
    password: password.value,
    email: email.value,
    createTime: +new Date(),
    updateTime: +new Date(),
  };

  if (password.value !== confirmPassword.value) {
    toast.notify("密码输入不一致");
    return;
  }

  try {
    const res = await registerPost(data);
    if (res.status === 200) {
      toast.notify("注册成功");
      router.push("/login");
    }
  } catch (error) {
    toast.notify("注册失败已有同名用户");
  }
};
</script>

<style scoped>
.register-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}
</style>
