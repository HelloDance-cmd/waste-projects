<template>
  <div class="flex w-[90%] mt-6">
    <div>
      <UserProfile :info="info" />
    </div>
    <div>
      <article v-for="article in articleListShow" :key="article.id">
        <RouterLink :to="'/article/' + article.id" :key="article.id">
          <ArticleCard :description="article.content" :title="article.title" />
        </RouterLink>
      </article>
      <VaPagination
        v-model="currentPageNumber"
        :pages="totalPage"
        :visible-pages="prePage"
        class="justify-center sm:justify-start"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import { getInformationForMe, requestArticles } from "../request";
import { onMounted, reactive, ref, watch } from "vue";
import { type Article } from "../types/Article";
import { RouterLink } from "vue-router";
import ArticleCard from "../components/ArticleCard.vue";
import UserProfile from "./UserProfile.vue";
import { AboutMe } from "../types/AboutMe";

let articleList = reactive<Article[]>([]); // 后端返回的文章
let articleListShow = reactive<Article[]>([]); // 显示在页面上的文章
const currentPageNumber = ref(1);
const prePage = 7; // 每页可以展示多少条文章列表
const totalPage = ref<number>(0); // 总页数 需要计算
const info = reactive<AboutMe>({} as AboutMe);

watch(currentPageNumber, () => {
  // articleListShow.
  articleListShow.length = 0;
  let startPage = (currentPageNumber.value - 1) * prePage;
  let endPage = startPage + prePage;
  Object.assign(articleListShow, articleList.slice(startPage, endPage));
});

onMounted(async () => {
  const res = await requestArticles();
  Object.assign(articleList, res.data);

  totalPage.value = Math.ceil(articleList.length / prePage);

  Object.assign(
    articleListShow,
    articleList.slice(currentPageNumber.value - 1, prePage)
  );

  // 获取我的信息
  Object.assign(info, (await getInformationForMe()).data);
});
</script>

<style scoped>
article {
  border: 1px solid #ccc;
  padding: 10px;
  margin-bottom: 20px;
}
</style>
