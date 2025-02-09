<script setup lang="ts">

import ArticleCard from "@/components/article/ArticleCard.vue";
import {onMounted, reactive, useId} from "vue";
import {getAllArticles} from "@/requests/article";
import {ArticleInfo} from "@/type/ArticleType";

const articles = reactive<ArticleInfo[]>([]);

onMounted(() => {
  getAllArticles().then(res => Object.assign(articles, res.slice(0, 4)));
})

</script>

<template>
  <div class="w-full h-[70vh] bg-gray-100 flex flex-col items-center justify-center">
    <div class="text-[5rem] text-center">
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae, ut?
    </div>
    <button class="px-10 py-3 bg-[#000] text-white rounded-lg transition-all duration-150 hover:scale-110">
      <RouterLink to="/articles">进入博客</RouterLink>
    </button>
  </div>

  <div class="mt-10 p-10">
    <div class="text-xl font-bold mb-2" style="z-index: 999"># 最近文章</div>
    <div class="flex flex-row gap-3 flex-wrap justify-center">
      <ArticleCard v-for="article in articles" :key="useId()" :article="article" />
    </div>
  </div>

  <div class="w-full p-10 bg-[#000]"></div>
</template>

<style scoped>

</style>