<template>
  <q-layout view="hHh lpr fFf">
    <AppHeader />
    <q-page-container @scroll="onScroll">
      <ContactUs />
    </q-page-container>
    <AppFooter />
  </q-layout>
</template>

<script>
import ContactUs from "../components/ContactUs.vue";
import AppFooter from "../components/AppFooter.vue";
import AppHeader from "../components/AppHeader.vue";

export default {
  name: "ContactUsLayout",
  components: {
    ContactUs,
    AppFooter,
    AppHeader,
  },
};
</script>
