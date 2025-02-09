<template>
  <!-- <view
    style="width: 100%; height: 1rem; display: flex; flex-direction: column"
  >
    <view
      style="width: 100%; height: 50%"
      :style="{ backgroundColor: $props.primaryColor }"
    ></view>
    <view
      style="width: 100%; height: 50%"
      :style="{ backgroundColor: $props.secondaryColor }"
    ></view>
  </view> -->

  <view
    :style="{
      width: '100%',
      height: '1rem',
      outline: `1px solid ${$props.secondaryColor}`,
      backgroundColor: $props.primaryColor,
    }"
  ></view>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "ColorBlock",
  props: {
    primaryColor: {
      type: String,
      required: true,
    },
    secondaryColor: {
      type: String,
      required: true,
    },
  },
  data() {
    return {
      styleAttrs: {},
    };
  },
});
</script>
