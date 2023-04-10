<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <viewpets />
  </div>
</template>

<script>
import viewpets from '../components/ViewPets.vue';

export default {
  name: 'Home',
  components: {
    viewpets
  }
}
</script>

<style>
html, body {
  height: 100%;
}
.home {
 
}
</style>
