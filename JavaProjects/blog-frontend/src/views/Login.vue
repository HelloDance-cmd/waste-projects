<template>
  <div class="w-[80%] h-[70vh] flex items-center justify-center">
    <h2 class="text-[230%] font-extrabold text-center">登录</h2>
    <VaForm
      ref="registerForm"
      stateful
      class="mb-2 flex flex-col gap-2"
      @submit.prevent="login"
    >
      <VaInput
        required-mark
        name="username"
        label="用户名"
        v-model="username"
      />
      <VaInput required-mark name="password" label="密码" v-model="password" />
      <VaButton type="submit">登录</VaButton>
    </VaForm>
  </div>
</template>

<script lang="ts" setup>
import { userLoggined } from "../request";
import { useRouter } from "vue-router";
import { ref } from "vue";
import { useToast } from "vuestic-ui/web-components";
const toast = useToast();

const router = useRouter();
const username = ref("");
const password = ref("");

const login = async () => {
  try {
    const res = await userLoggined(username.value, password.value);
    if (res.status === 200) {
      toast.notify("登录成功");
      router.push("/");
    }
  } catch (error) {
    console.log(error);
    toast.notify("用户名或密码错误");
  }
};
</script>
<style scoped>
.login-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}
</style>
