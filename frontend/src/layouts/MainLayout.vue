<template>
  <q-layout view="hHh lpr fFf">
    <AppHeader />
    <q-page-container @scroll="onScroll">
      <Home />
      <PetSearch />
    </q-page-container>
    <AppFooter />
  </q-layout>
</template>

<script>
import Home from "../components/Home.vue";
import PetSearch from "src/components/PetSearch.vue";
import AppFooter from "../components/AppFooter.vue";
import AppHeader from "../components/AppHeader.vue";

export default {
  name: "MainLayout",
  components: {
    Home,
    PetSearch,
    AppFooter,
    AppHeader,
  },
};
</script>
