<template>
    <button v-bind="$props" class="rounded-md bg-black text-white px-6 py-2 hover:bg-slate-800 transition-all delay-100">
        <slot></slot>
    </button>
</template>

<script>
export default {
    name: 'BrickButton',
}
</script>

<style>

</style>