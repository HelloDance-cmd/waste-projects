<script setup lang="ts">
import {ArticleInfo} from "@/type/ArticleType";

const props = defineProps<{
  article: ArticleInfo
}>()

const maxShowLength = 30; // 30 words in Chinese

</script>

<template>
  <div
      class="bg-white shadow-6 flex flex-col w-[300px] gap-1 p-4 rounded-lg border-2 hover:scale-110 transition-all duration-150">
    <div class="height-[150px] overflow-hidden">
      <img src="https://picsum.photos/id/1/200/300" alt="" width="300" height="400" class="rounded"/>
    </div>
    <div class="flex flex-col text-lg font-bold">{{ props.article.title }}</div>
    <div>{{ props.article.content.slice(0, maxShowLength) }}
    </div>
  </div>
</template>

<style scoped>

</style>