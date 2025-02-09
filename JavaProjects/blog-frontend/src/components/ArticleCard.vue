<template>
  <VaCard color="primary" gradient class="flex flex-col w-full">
    <VaCardTitle style="font-size: 1.5rem">{{ title }}</VaCardTitle>
    <VaCardContent>
      {{ description.slice(0, LIMITES_CONTENT) }}
    </VaCardContent>
  </VaCard>
</template>

<script setup lang="ts">
const LIMITES_CONTENT = 130;
interface Props {
  title: string;
  description: string;
}

const { title, description } = defineProps<Props>();
</script>
