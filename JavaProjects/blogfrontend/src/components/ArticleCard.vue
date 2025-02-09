<script setup lang="ts">

</script>

<template>
  <div class="flex flex-col w-full p-5 border-2 rounded-lg gap-2">
    <div class="text-lg font-bold">
      <slot name="title"></slot>
    </div>
    <div>
      <slot></slot>
    </div>
    <div class="text-gray-600">
      <slot name="desc"></slot>
    </div>
  </div>
</template>

<style scoped>

</style>