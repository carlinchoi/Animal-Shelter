<template>
  <div class="home">
     <div class="background-image"></div>
    <h1>Home</h1>
   <p class="message">You must be authenticated to see this</p> 
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

.home {
  position: relative;
  width: 100%;
  height: 100%;
}
.background-image {
   position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 20%;
  background-image: url('../assets/background2.png');
  background-repeat: repeat;
  background-size: contain;
  transform: rotate(45deg);
  z-index: -1;
}
.message {
  position: relative;
  z-index: 1;
}
</style>
