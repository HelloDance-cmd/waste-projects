<template>
  <view>
    <view class="page-header">
      <view class="topic">
        {{ $props.topic }}
      </view>
      <view
        v-if="!pageChanging"
        class="page"
        @click="pageChanging = !pageChanging"
      >
        - {{ $props.page }} -
      </view>
      <view v-else>
        <input
          type="text"
          :value="$props.page"
          style="width: 2rem; background-color: white; border: 1px solid black"
          @blur="pageChange(parseInt($event.target.value))"
          @keyup.enter="pageChange(parseInt($event.target.value))"
        />
      </view>
    </view>
    <hr />
  </view>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  name: "PageHeader",
  props: {
    page: Number,
    topic: String,
  },
  data() {
    return {
      pageChanging: false,
    };
  },
  methods: {
    pageChange(page: number) {
      this.pageChanging = false;
      this.$emit("pageChange", page);
    },
  },
});
</script>

<style scoped>
.page-header {
  display: flex;
  justify-content: space-between;
}

.topic {
  font-weight: bold;
}

.page {
  font-weight: bold;
}
</style>
