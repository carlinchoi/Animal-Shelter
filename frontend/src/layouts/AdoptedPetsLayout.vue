<template>
  <q-layout view="hHh lpr fFf" >
    <AppHeader />
    <q-page-container @scroll="onScroll">
      <AdoptedPets/>
    </q-page-container>
    <AppFooter />
  </q-layout>

</template>

<script>
import AdoptedPets from '../components/AdoptedPets.vue'
import AppFooter from '../components/AppFooter.vue'
import AppHeader from '../components/AppHeader.vue'

export default {
  name: 'AdoptedPetsLayout',
  components: {
    AdoptedPets,
    AppFooter,
    AppHeader
  }
}
</script>
