<template>
  <q-layout view="hHh lpr fFf">
    <AppHeader />
    <q-page-container @scroll="onScroll">
      <FaqComponent />
    </q-page-container>
    <AppFooter />
  </q-layout>
</template>

<script>
import FaqComponent from "../components/FaqComponent.vue";
import AppFooter from "../components/AppFooter.vue";
import AppHeader from "../components/AppHeader.vue";

export default {
  name: "FaqLayout",
  components: {
    FaqComponent,
    AppFooter,
    AppHeader,
  },
};
</script>
