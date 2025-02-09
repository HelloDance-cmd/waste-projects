<script setup lang="ts">

</script>

<template>
  <div class="w-full p-3 flex flex-row justify-center items-center gap-6 hover:cursor-pointer">
    <RouterLink to="/" active-class="font-bold">
      <div class="p-2 px-6 hover:font-bold rounded">主页</div>
    </RouterLink>
    <RouterLink to="/articles" active-class="font-bold">
      <div class="p-2 px-6 hover:font-bold rounded">博客</div>
    </RouterLink>

    <div class="relative group/item">
      <span class="p-2 px-6 group-hover/item:font-bold rounded">个人中心</span>
      <div
          class="scale-0 group-hover/item:scale-100 group-hover/item:flex  transition-all duration-120  flex-col w-[120px] absolute top-[30px] bg-white border-2">
        <div class="hover:bg-gray-3 text-center py-2 px-4 border-b-2">作品管理</div>
        <div class="hover:bg-gray-3 text-center py-2 px-4 ">登出</div>
      </div>
    </div>
  </div>
</template>
<style scoped>

</style>