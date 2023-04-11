<template>
  <div class="sidebar" id="rightSidebar">
    <button class="button"
  onclick="close()">Close &times;</button>
  </div>
</template>

<style>
.sidebar {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  width: 25%; 
  background-color: #f2f2f2;
  border: 1px solid #ddd; 
  padding: 20px; 
  overflow-y: scroll; 
  height: 80%;
  padding-top: 20px;
  padding-bottom: 20px;
}
</style>

<script>
// function close() {
//     document.getElementById("rightSidebar").style.display = "none";
// }
</script> 