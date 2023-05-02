<template>
  <q-layout view="hHh lpr fFf" >
    <q-page-container @scroll="onScroll">
      <AddNewPetComponent />
    </q-page-container>
  </q-layout>

</template>

<script>

import AddNewPetComponent from 'src/components/AddNewPet.vue'
export default {
  components: {
    AddNewPetComponent
  }
}
</script>

