import { createRouter, createWebHistory } from "vue-router";
import ArticleDetail from "@/views/ArticleDetail.vue";
import Login from "@/views/Login.vue";
import Register from "@/views/Register.vue";
import UserProfile from "@/views/UserProfile.vue";
import Home from "@/views/Home.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      name: "Home",
      component: Home,
    },
    {
      path: "/article/:articleId",
      name: "ArticleDetail",
      component: ArticleDetail,
      props: true,
    },
    {
      path: "/login",
      name: "Login",
      component: Login,
    },
    {
      path: "/register",
      name: "Register",
      component: Register,
    },
    {
      path: "/profile",
      name: "UserProfile",
      component: UserProfile,
    },
  ],
});

export default router;
