import { createMemoryHistory, createRouter } from 'vue-router'

import HomeView from "@/view/HomeView.vue";
import ArticlesView from "@/view/ArticlesView.vue";

const routes = [
    { path: '/', component: HomeView },
    { path: '/articles', component: ArticlesView },
]

const router = createRouter({
    history: createMemoryHistory(),
    routes,
})

export default router