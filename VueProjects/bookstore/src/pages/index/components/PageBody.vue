<template>
  <view class="body">
    <view class="next" @click.stop="$props.next"></view>
    <view class="prev" @click.stop="$props.prev"></view>

    <template v-for="subtitle in $props.subtitles">
      <view v-if="subtitle.chapterTitle != null" class="chapterTitle">
        {{ subtitle.chapterTitle }}
      </view>
      <view class="title" :key="subtitle.id" v-html="subtitle.title"> </view>

      <view class="body" v-html="subtitle.content" :key="subtitle.id"></view>
    </template>
  </view>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "PageHeader",
  data() {
    return {
      rendered: false,
    };
  },
  props: {
    subtitles: {
      type: Array,
      required: true,
    },
    next: {
      type: Function,
      required: true,
    },
    prev: {
      type: Function,
      required: true,
    },
  },
});
</script>

<style scoped>
.title {
  font-weight: bolder;
  text-align: center;
  margin-top: 0.8rem;
}
.body {
  text-indent: 2ch;
  position: relative;
}

.next,
.prev {
  /* opacity: 0.5; */
  opacity: 1;
  background-color: transparent;
  width: 40%;
  height: 100%;
  position: absolute;
  top: 0;
  z-index: 999;
}

.next {
  right: 0;
}

.prev {
  left: 0;
}

.chapterTitle {
  font-weight: bold;
  font-size: 140%;
  font-family: "微软雅黑";
}
</style>
