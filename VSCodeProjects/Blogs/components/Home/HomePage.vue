<script setup lang="ts">
import HomeBanner from "./HomeBanner.vue"
import HomeFeatures from "./HomeFeatures.vue";
import {reactive, mounted, defineAsyncComponent} from "vue";
import {getStreamerInfo} from "@/services";

const HomeStreamer = defineAsyncComponent(() => import("./HomeSteamer.vue"))

// 根据接口确定是否显示Steamer
const streamerInfo = reactive({});
mounted(async () => (streamerInfo = await getStreamerInfo()));
</script>

<template>
    <HomeStreamer v-if="streamerInfo.message != null" streamerInfo="streamerInfo" />
    <HomeBanner />
    <HomeFeatures />
</template>