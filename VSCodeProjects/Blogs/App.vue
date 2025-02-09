<script setup>
import NavBar from "./components/Navbar";
import {RouterView} from "vue-router";
import BlogDescription from "./components/BlogDescription";
</script>

<template>
    <main>
        <NavBar />
        <RouterView />
        <BlogDescription />
    </main>
</template>