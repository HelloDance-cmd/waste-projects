<template>
  <div
    class="user-profile-container flex flex-col gap-3 items-center border-gray-100"
  >
    <div>
      <VaAvatar size="large" font-size="30px" class="mr-6"> WU </VaAvatar>
    </div>
    <div>
      <VaBadge
        :text="skill"
        color="primary"
        class="mr-2"
        :key="idx"
        v-for="(skill, idx) in tagsSkill"
      />
    </div>
    <div style="line-height: 1.5; text-indent: 2ch">
      {{ info.detailed_bio }}
    </div>
  </div>
</template>

<script setup lang="ts">
import { AboutMe } from "../types/AboutMe";

const { info } = defineProps<{
  info: AboutMe;
}>();

let tagsSkill = info.skills?.split("、");
</script>

<style scoped>
.user-profile-container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}
</style>
