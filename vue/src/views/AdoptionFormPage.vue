<template>
  <div>
    <adoption-form
      v-bind:petId="parseInt($route.params.petId)" />
      <!-- v-bind:pet="($route.params.pet)" /> -->
  </div>
</template>

<script>
import AdoptionForm from "../components/AdoptionForm.vue";

export default {
  components: {
    AdoptionForm
  }
};
</script>

<style>
</style>