<template>
  <view
    class="settings__display"
    v-if="$props.colorChoice || $props.fontChoice || $props.praghChoice"
  >
    <!-- 
      选择颜色的面板
  -->
    <view v-if="$props.colorChoice">
      <view
        class="color-choice"
        @click="$props.changeTheme('#000000', '#FFFFFF')"
      >
        <ColorBlock primaryColor="#000" secondaryColor="#fff" />
        <text>深色</text>
      </view>

      <view
        class="color-choice"
        @click="$props.changeTheme('#EBEBEB', '#000000')"
      >
        <ColorBlock primaryColor="#fff" secondaryColor="#000" />
        <text>浅色</text>
      </view>

      <view
        class="color-choice"
        @click="$props.changeTheme('#FAF9DE', '#000000')"
      >
        <ColorBlock primaryColor="#faf9de" secondaryColor="#000" />
        <text>护眼</text>
      </view>
    </view>
    <!-- 
      选择字体的面板
    -->
    <view v-if="$props.fontChoice">
      <view>
        <view @click="$props.changeFontFamily('宋体')">
          <image
            style="width: 2rem; height: 2rem; display: block"
            src="../../../static/home/默认字体.svg"
          />
        </view>
        <text>默认</text>
      </view>

      <view>
        <view @click="$props.changeFontFamily('微软雅黑')">
          <image
            style="width: 2rem; height: 2rem; display: block"
            src="../../../static/home/微软雅黑.svg"
          />
        </view>
        <text>微软雅黑</text>
      </view>
    </view>
    <!-- 
      选择段落的面板
    -->
    <view v-if="$props.praghChoice">
      <view>
        <view @click="$props.changeLineHeight(1.5)">
          <image
            style="width: 2rem; height: 2rem; display: block"
            src="../../../static/home/行距矮.svg"
          />
        </view>
        <text>狭窄</text>
      </view>

      <view>
        <view @click="$props.changeLineHeight(2)">
          <image
            style="width: 2rem; height: 2rem; display: block"
            src="../../../static/home/行距高.svg"
          />
        </view>
        <text>宽松</text>
      </view>
    </view>
  </view>
</template>

<script lang="ts">
import Vue from "vue";
import ColorBlock from "../components/ColorBlock.vue";

export default Vue.extend({
  name: "SettingPanel",
  props: [
    "colorChoice",
    "fontChoice",
    "praghChoice",
    "changeLineHeight",
    "changeFontFamily",
    "changeTheme",
  ],
  components: {
    ColorBlock,
  },
});
</script>

<style>
.settings__display {
  width: 100%;
  position: absolute;
  bottom: 46px;
  height: auto;
  padding: 15px;
  background-color: #ededed;

  font-size: 80%;
}

.settings__display > view {
  display: flex;
  flex-direction: row;

  justify-content: space-evenly;
}

.settings__display > view > view {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 0.5px;
}
</style>
