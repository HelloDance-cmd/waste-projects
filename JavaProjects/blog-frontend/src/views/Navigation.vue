<template>
  <VaNavbar color="#0f0f10" class="h-16">
    <template #left>
      <VaNavbarItem class="logo">BRICKS</VaNavbarItem>
    </template>
    <template #right>
      <VaNavbarItem class="hidden sm:block">
        <RouterLink to="/">首页</RouterLink>
      </VaNavbarItem>
      <VaNavbarItem class="hidden sm:block">
        <RouterLink to="/login" v-if="!loggined">登录</RouterLink>
      </VaNavbarItem>
      <VaNavbarItem class="hidden sm:block">
        <RouterLink to="/register" v-if="!loggined">注册</RouterLink>
      </VaNavbarItem>
    </template>
  </VaNavbar>
</template>

<script setup lang="ts">
import { useUserLoggingStore } from "../stores/user";

const userLogginedStore = useUserLoggingStore();

const loggined = userLogginedStore.isLogin;
</script>
