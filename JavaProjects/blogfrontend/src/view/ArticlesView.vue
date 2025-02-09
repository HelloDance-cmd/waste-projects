<script setup lang="ts">

import ArticleCard from "@/components/ArticleCard.vue";
import {onMounted, reactive, useId} from "vue";
import {getAllArticles} from "@/requests/article";
import {ArticleInfo} from "@/type/ArticleType";

const articles = reactive<ArticleInfo[]>([]);

onMounted(() => {
  getAllArticles().then(res => {
    Object.assign(articles, res);
  });
})

</script>

<template>
  <div class="flex flex-col justify-center items-center">
    <div class="w-1/2 flex flex-col gap-3">
      <ArticleCard v-for="article in articles" :key="useId()" class="hover:bg-gray-100">
        <template #title>
          {{ article.title }}
        </template>
        <template #default>
          {{ article.content.substring(0, 30)}}...
        </template>
      </ArticleCard>
    </div>
  </div>
</template>

<style scoped>

</style>