<template>
     <footer class="shelter-footer"> 
         &copy; 2023. All rights reserved
     </footer>
</template>


<script>
export default {
    name:"the-footer"
}
</script>

<style>
.shelter-footer  {
  align-items: center;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  padding: 3px 10px;
  background-color: #034f3c;
  width: 100%;
  border: #00514f solid;
  margin-bottom: 3px;
  position: fixed;
  bottom:0;
  left: 0;
  background-color: rgb(195, 226, 199);
  backdrop-filter: blur(10px);
  height: 50px;
  box-shadow: 0px 0px 5px;
}

</style>


