<template>
  <view class="book-playground">
    <view
      class="book__display"
      :style="{
        backgroundColor: bookDisplayBackgroundColor,
        color: textOfBookDisplayColor,
        lineHeight: display.lineHeight,
        fontFamily: display.fontFamily,
        fontSize: info.fontSize + 'px', // 调整字体大小，适应设备的尺寸
      }"
      @click="handleControlPanelShow"
    >
      <!-- 显示主题文字 -->
      <PageHeader
        v-bind:page="topicShow.page"
        v-bind:topic="topicShow.title"
        @pageChange="pageChange"
      />
      <PageBody
        :subtitles="topicShow.subtitles"
        :next="nextPage"
        :prev="prevPage"
      />
    </view>
    <BookControlPanel
      v-if="display.isControlPanelShow"
      :display="display"
      :changeTheme="changeTheme"
      :changeLineHeight="changeLineHeight"
      :changeFontFamily="changeFontFamily"
      :panelChoice="panelChoice"
    />
  </view>
</template>

<script lang="ts">
import Vue from "vue";

import {
  type BackgroundColorChoice,
  type TextColorChoice,
  type FontChoice,
} from "./types/BooksPanel";
import BookControlPanel from "./components/BookControlPanel.vue";

import TopicParse, { TopicResult } from "./utils/topic-parse";
import PageBody from "./components/PageBody.vue";
import PageHeader from "./components/PageHeader.vue";

import { getFontConfigration } from "./utils/getSystemInfo";

export default Vue.extend({
  data() {
    return {
      bookDisplayBackgroundColor: "#EBEBEB",
      textOfBookDisplayColor: "#000000",
      display: {
        isNavShow: true,
        isControlPanelShow: false,
        lineHeight: 2,
        fontFamily: "宋体",
        colorChoice: false,
        fontChoice: false,
        praghChoice: false,
      },
      topices: [] as TopicResult[],
      topicShow: {} as TopicResult,
      info: getFontConfigration(),
      currentPage: 1,
    };
  },
  created() {
    (async () => {
      const rep = await fetch("body.txt");
      const text = await rep.text();

      this.topices = TopicParse.parseTopic(text) as TopicResult[];
      this.topicShow = this.topices[this.currentPage - 1];
    })();
  },
  methods: {
    /**
     * 控制底部的控制面板显示
     */
    handleControlPanelShow() {
      this.display.isControlPanelShow = !this.display.isControlPanelShow;
    },
    /**
     *  更改主题
     * @param backgroundColor
     * @param textColor
     */
    changeTheme(
      backgroundColor: BackgroundColorChoice,
      textColor: TextColorChoice
    ) {
      this.bookDisplayBackgroundColor = backgroundColor;
      this.textOfBookDisplayColor = textColor;
    },
    /**
     * 更改行高
     * @param val
     */
    changeLineHeight(val: number) {
      this.display.lineHeight = val;
    },
    /**
     *  更改字体
     * @param val
     */
    changeFontFamily(val: FontChoice) {
      this.display.fontFamily = val;
    },
    /**
     * 控制面板的选择，显示对应的控制面板
     * @param val
     */
    panelChoice(val: String) {
      switch (val) {
        case "font":
          this.display.fontChoice = true;
          this.display.colorChoice = false;
          this.display.praghChoice = false;
          break;
        case "color":
          this.display.fontChoice = false;
          this.display.colorChoice = true;
          this.display.praghChoice = false;
          break;
        case "pragh":
          this.display.fontChoice = false;
          this.display.colorChoice = false;
          this.display.praghChoice = true;
          break;
      }
    },
    /**
     * 下一页
     */
    nextPage(event: Event) {
      // event.stopPropagation();
      // let { page: currentPage } = this.topicShow;

      // let topic = this.topices.find(
      //   (topic) => topic.page === (currentPage as number) + 1
      // );
      // if (topic === undefined) {
      //   alert("没有页面了");
      // } else {
      //   this.topicShow = topic;
      // }
      this.currentPage++;
      this.topicShow = this.topices[this.currentPage - 1];
    },
    /**
     * 上一页
     */
    prevPage(event: Event) {
      // event.preventDefault();
      // let { page: currentPage } = this.topicShow;

      // let topic = this.topices.find(
      //   (topic) => topic.page === (currentPage as number) - 1
      // );
      // if (topic === undefined) {
      //   alert("没有页面了");
      // } else {
      //   this.topicShow = topic;
      // }
      this.currentPage--;
      this.topicShow = this.topices[this.currentPage - 1];
    },
    /**
     *  页面跳转
     * @param page
     */
    pageChange(page: number) {
      let topic = this.topices.find((topic) => topic.page === page);
      if (topic === undefined) {
        alert("没有页面了");
      } else {
        this.topicShow = topic;
      }
    },
  },
  watch: {
    /**
     * 检测底部的控制面板是否显示
     * 如果显示需要其他的控制面板隐藏
     * @param val 底部的控制面板是否显示
     */
    "display.isControlPanelShow": function (val: Boolean) {
      if (val === false) {
        this.display.fontChoice = false;
        this.display.colorChoice = false;
        this.display.praghChoice = false;
      }
    },
  },
  components: {
    BookControlPanel,
    PageBody,
    PageHeader,
  },
});
</script>

<style>
.book-playground {
  width: 100%;
  height: 100vh;
  position: relative;
  display: flex;
  flex-direction: column;
  background-color: #faf9de;
}
.book__display {
  width: 100%;
  height: 100%;
  overflow: auto;

  box-sizing: border-box;

  padding: 1.5rem;

  text-indent: 2ch;
}
</style>
