<template>
  <div>
    <view-adoptions
      v-bind:petId="parseInt($route.params.petId)" 
      v-bind:petName="($route.params.petName)" /> 
  </div>
</template>

<script>
import ViewAdoptions from "../components/ViewAdoptions.vue";

export default {
  components: {
    ViewAdoptions
  }
};
</script>

<style>
</style>