<template>
  <q-layout view="hHh lpr fFf">
    <AppHeader />
    <view-volunteers />
    <AppFooter />
  </q-layout>
</template>

<script>
import ViewVolunteers from "src/components/ViewVolunteers.vue";
import AppFooter from "../components/AppFooter.vue";
import AppHeader from "../components/AppHeader.vue";

export default {
  name: "ViewVolunteersLayout",
  components: {
    ViewVolunteers,
    AppFooter,
    AppHeader,
  },
};
</script>
