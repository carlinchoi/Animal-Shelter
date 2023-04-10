<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home"
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
