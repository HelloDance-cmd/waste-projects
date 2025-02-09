import "tailwindcss/tailwind.css";
import "vuestic-ui/css";
import "material-design-icons-iconfont/dist/material-design-icons.min.css";
import Vuestic from "./utils/vuestic-ui";

import {createPinia} from "pinia";
import {createApp} from "vue";
import router from "./router";
import App from "./App.vue";

const pinia = createPinia();

createApp(App)
    .use(router)
    .use(pinia)
    .use(Vuestic)
    .mount("#app");
