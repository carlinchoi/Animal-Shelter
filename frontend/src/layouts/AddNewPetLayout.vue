<template>
  <q-layout view="hHh lpr fFf" >
    <AppHeader />
    <q-page-container @scroll="onScroll">
      <AddNewPetComponent />
    </q-page-container>
    <AppFooter />
  </q-layout>

</template>

<script>
import AppHeader from 'src/components/AppHeader.vue';
import AppFooter from 'src/components/AppFooter.vue';
import AddNewPetComponent from 'src/components/AddNewPet.vue'
export default {
  components: {
    AppFooter,
    AppHeader,
    AddNewPetComponent
  }
}
</script>

<style>

</style>
