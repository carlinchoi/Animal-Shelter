<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <test-component></test-component>
  </div>
</template>

<script>
import TestComponent from '../components/TestComponent.vue';

export default {
  name: 'Home',
  components: {

    TestComponent 
  }
}
</script>

<style>
@font-face {
  font-family: Nunito Sans;
}
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

