<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <!-- <test-component></test-component> -->
    <view-pets></view-pets>
  </div>
</template>

<script>
import viewpets from "../components/ViewPets.vue"
// import TestComponent from "../components/TestComponent.vue"
export default {
  components: 
  // { TestComponent}, 
  viewpets, 
  name: "home",
  
};
</script>

<style>
html, body {
  height: 100%;
}
.home {
  background-color: purple;
  background-image: url("../assets/background.png");
  background-size: repeat;
}
</style>
