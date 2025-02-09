<template>
  <!-- 控制文字显示 -->
  <view class="book__control-panel" v-if="display.isControlPanelShow">
    <view @click="$props.panelChoice('color')">
      <svg
        t="1736565941561"
        class="setting"
        viewBox="0 0 1024 1024"
        version="1.1"
        xmlns="http://www.w3.org/2000/svg"
        p-id="12080"
        xmlns:xlink="http://www.w3.org/1999/xlink"
        width="200"
        height="200"
      >
        <path
          d="M512 0a512 512 0 0 0 0 1024c180.224 0-110.592-204.8 204.8-204.8a302.08 302.08 0 0 0 307.2-307.2A512 512 0 0 0 512 0zM179.2 486.4A76.8 76.8 0 1 1 256 409.6a76.8 76.8 0 0 1-76.8 76.8zM358.4 307.2a76.8 76.8 0 1 1 76.8-76.8A76.8 76.8 0 0 1 358.4 307.2z m307.2 0a76.8 76.8 0 1 1 76.8-76.8A76.8 76.8 0 0 1 665.6 307.2z m179.2 179.2A76.8 76.8 0 1 1 921.6 409.6a76.8 76.8 0 0 1-76.8 76.8z"
          fill="#333333"
          p-id="12081"
        ></path>
      </svg>
    </view>
    <view @click="$props.panelChoice('font')">
      <svg
        t="1736565635727"
        class="setting font-setting"
        viewBox="0 0 1024 1024"
        version="1.1"
        xmlns="http://www.w3.org/2000/svg"
        p-id="10071"
        xmlns:xlink="http://www.w3.org/1999/xlink"
        width="200"
        height="200"
      >
        <path
          d="M913.408 1024l-66.56 0q-29.696 0-51.2-5.12t-36.864-15.872-26.112-27.136-19.968-37.888q-15.36-38.912-28.16-70.656t-22.016-55.296q-11.264-26.624-20.48-49.152l-254.976 0q-7.168 23.552-17.408 51.2-8.192 23.552-21.504 56.832t-30.72 72.192q-20.48 46.08-47.104 63.488t-60.416 17.408l-70.656 0q-45.056 0-60.928-19.968t2.56-68.096q18.432-46.08 43.008-108.544t52.224-132.608 57.344-143.872 57.344-144.384q65.536-164.864 137.216-343.04 7.168-17.408 18.432-31.744 10.24-11.264 27.136-21.504t42.496-10.24q26.624 0 43.52 10.752t28.16 24.064q12.288 15.36 19.456 33.792 72.704 180.224 138.24 345.088 27.648 70.656 57.344 143.872t56.832 142.336 51.2 129.536 41.472 104.448q14.336 34.816 4.096 62.464t-43.008 27.648zM616.448 634.88l-97.28-347.136-1.024 0-108.544 347.136 206.848 0z"
          p-id="10072"
        ></path>
      </svg>
    </view>
    <view @click="$props.panelChoice('pragh')">
      <svg
        t="1736565931709"
        class="setting"
        viewBox="0 0 1024 1024"
        version="1.1"
        xmlns="http://www.w3.org/2000/svg"
        p-id="11051"
        xmlns:xlink="http://www.w3.org/1999/xlink"
        width="200"
        height="200"
      >
        <path
          d="M0 128 1024 128 1024 256 0 256 0 128ZM0 448 1024 448 1024 576 0 576 0 448ZM0 768 704 768 704 896 0 896 0 768Z"
          fill="#666666"
          p-id="11052"
        ></path>
      </svg>
    </view>
    <SettingPanel
      :colorChoice="display.colorChoice"
      :fontChoice="display.fontChoice"
      :praghChoice="display.praghChoice"
      :changeTheme="changeTheme"
      :changeLineHeight="changeLineHeight"
      :changeFontFamily="changeFontFamily"
    />
  </view>
</template>

<script lang="ts">
import Vue from "vue";
import SettingPanel from "./SettingPanel.vue";

export default Vue.extend({
  props: {
    display: {
      type: Object,
      required: true,
    },
    changeTheme: {
      type: Function,
      required: true,
    },
    changeLineHeight: {
      type: Function,
      required: true,
    },
    changeFontFamily: {
      type: Function,
      required: true,
    },
    panelChoice: {
      type: Function,
      required: true,
    },
  },
  components: {
    SettingPanel,
  },
});
</script>

<style>
/* 控制文本区域 */
.book__control-panel {
  width: 100%;
  height: 7%;
  background-color: white;

  padding: 1.5rem;
  box-sizing: border-box;
  position: fixed;
  bottom: 0;
  z-index: 999;

  display: flex;
  flex-direction: row;
  gap: 0.4rem;
  justify-content: space-evenly;
  align-items: center;

  box-shadow: 0 -5px 20px 0 lightgray;
}

.book__control-panel .setting {
  width: 16px;
  height: 16px;
  display: block;
  color: black;
}

.holdbar {
  width: 20%;
  height: 5%;
  border-radius: 10%;
  background-color: lightgrey;
}

.control__colorpicker,
.control__lineheightChanger,
.control_fontChanger {
  display: flex;
  flex: row;
  justify-content: center;
  gap: 5ch;
}

.control__colorpicker > view,
.control__lineheightChanger > view,
.control_fontChanger > view {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 0.5ch;
}
</style>
