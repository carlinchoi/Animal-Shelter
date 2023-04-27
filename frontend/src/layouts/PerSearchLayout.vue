<template>
  <PetSearch />
<AvailablePetsList />
</template>

<script>
import PetSearch from 'src/components/PetSearch.vue'
import AvailablePetsList from 'src/components/AvailablePetsList.vue'

export default {
  name: 'MainLayout',
  components: {

    PetSearch,
    AvailablePetsList,

  },
  data () {
    return {

    }
  }
}
</script>
