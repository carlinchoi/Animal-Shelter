<template>
  <div>
    <VolunteerApplication v-bind:username="($route.params.username)" />
  </div>
</template>

<script>
import VolunteerApplication from "../components/VolunteerApplication.vue";

export default {
  components: {
    VolunteerApplication,
  },
};
</script>

<style>

</style>