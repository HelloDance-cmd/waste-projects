import {createApp} from 'vue'
import {createPinia} from 'pinia'
import {createVuestic} from "vuestic-ui";
import Router from "@/route"

import App from './App.vue'

import "@/style.css"
// import "vuestic-ui/css";
// import 'vuestic-ui/styles/essential.css';
// import 'vuestic-ui/styles/typography.css';
// import "material-design-icons-iconfont/dist/material-design-icons.min.css";

const pinia = createPinia()
const app = createApp(App)

app.use(pinia)
    .use(createVuestic())
    .use(Router)
    .mount('#app')