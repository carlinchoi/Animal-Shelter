<template>
     <header class="shelter-heading">
        <img src="../assets/animalshelterlogo.png" alt="Rockville" />
    </header>
</template>

<script>
export default {
    name:"the-header"

}
</script>

<style scoped>
.shelter-heading  {
    display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding: 10px 30px;
  background-color: #034f3c;
  width: 100%;
  border: #00514f solid;
  margin-bottom: 5px;
position: fixed;
  top: 0;
  left: 0;
}
.shelter-heading img {
    border-radius: 25px;
    clip-path: polygon(85% 6%, 70% 15%, 30% 15%, 15% 5%, 0% 25%, 10% 45%, 10% 75%, 25% 90%, 40% 95%, 60% 95%, 75% 91%, 90% 75%, 90% 45%, 100% 25%);
}

</style>