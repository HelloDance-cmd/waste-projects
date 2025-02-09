<template>
  <div
    class="article-detail-container w-[75%] flex justify-center flex-col gap-10 py-10"
  >
    <div class="flex flex-col">
      <h1>{{ article.title }}</h1>
      <span class="self-end">{{
        article.updateTime?.toString().replaceAll("-", "/")
      }}</span>
    </div>
    <div
      style="line-height: 1.5"
      v-html="md.render(String(article.content))"
    ></div>
    <div class="w-full flex flex-col gap-5 mt-10">
      <h2>评论区</h2>
      <form @submit.prevent="postComment" class="flex flex-col gap-2">
        <VaTextarea
          v-model="comment"
          autosize
          max-rows="5"
          placeholder="请友好发言"
          class="w-full"
        />
        <VaButton @click="handleCommitComment" class="self-end"
          >提交评论</VaButton
        >
      </form>

      <div v-for="comment in commentList" :key="comment.id">
        <VaCard>
          <VaCardTitle>{{ comment.commentTime }}</VaCardTitle>
          <VaCardContent>
            {{ comment.commentContent }}
          </VaCardContent>
        </VaCard>
      </div>
    </div>
  </div>
</template>
<!-- 
登录->注册->
  1. 评论
  2. 查看
  3. 发布
-->
<script setup lang="ts">
import {
  commitUserComment,
  requestArticleById,
  getCommentListById,
} from "../request";
import { ref, reactive, onBeforeMount } from "vue";
import { type Article } from "../types/Article";
import { commentCreator, type Comment } from "../types/Comment";
import { useToast } from "vuestic-ui/web-components";
import markdown from "markdown-it";
import { useUserLoggingStore } from "../stores/user";

const toast = useToast();
const userLoggined = useUserLoggingStore();

const props = defineProps<{
  articleId: number | string;
}>();

const md = markdown();
let article = reactive<Article>({} as Article);
let commentList = reactive<Comment[]>([]);
let comment = ref<string>("");
let isLoggedIn = userLoggined.isLogin;
const newCommentContent = ref<string>("");

const getArticleDetails = async () => {
  try {
    const rep = await requestArticleById(props.articleId as number);
    Object.assign(article, rep.data);
  } catch (error) {
    toast.notify("暂时还没有任何文章哦");
  }
};
const getCommentList = async () => {
  try {
    const rep = await getCommentListById(props.articleId as number);
    Object.assign(commentList, rep.data);
  } catch (error) {
    console.log(error);
    toast.notify("暂时还没有任何评论哦");
  }
};

const handleCommitComment = async () => {
  commentList.push(commentCreator(comment.value));
};

const postComment = async (event: any) => {
  event.preventDefault();

  if (!isLoggedIn) {
    toast.notify("请先登录");
    return;
  }

  const commentData = {
    articleId: props.articleId,
    userId: article.authorId,
    commentContent: newCommentContent.value,
  };

  try {
    const res = await commitUserComment(newCommentContent.value);
    if (res.status === 200) {
      newCommentContent.value = "";
      getCommentList();
    }
  } catch (error) {
    console.log(error);
  }
};

onBeforeMount(() => {
  getArticleDetails();
  getCommentList();
});
</script>

<style scoped>
.article-detail-container {
  margin: 0 auto;
}

h1 {
  font-size: 250%;
}
</style>
