<template>
  <div class="home">
    <div class="background-image"></div>
    <!-- <h1>Home</h1> -->
    <div class="message-container">
      <!-- <p class="message">You must be authenticated to see this</p> -->
    </div>
    <view-pets />
  </div>
</template>

<script>
import viewPets from '../components/ViewPets.vue';

export default {
  name: 'home',
  components: {
    viewPets
  }
}
</script>

<style>
.home {
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
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
.message-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  position: relative;
  z-index: 1;
}

.message {
  margin-bottom: 1rem;
}

.logout-btn {
  padding: 0.5rem 1rem;
  font-size: 1rem;
  border: none;
  background-color: #00514f;
  color: white;
  cursor: pointer;
}
</style>