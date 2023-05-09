<template>
  <q-layout view="hHh lpr fFf" >
    <AppHeader />
      <ApproveVolunteers/>
    <AppFooter />
  </q-layout>

</template>

<script>
import ApproveVolunteers from 'src/components/ApproveVolunteers.vue'
import AppFooter from '../components/AppFooter.vue'
import AppHeader from '../components/AppHeader.vue'

export default {
  name: 'ViewVolunteersLayout',
  components: {
    ApproveVolunteers,
    AppFooter,
    AppHeader
  }
}
</script>

