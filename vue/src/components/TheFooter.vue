<template>
     <footer class="shelter-footer"> 
          <p class="copy"> &copy; 2023 Rockville Animal Shelter. All rights reserved.</p>   
             <ion-icon name="logo-instagram"></ion-icon>
             <ion-icon name="logo-facebook"></ion-icon>
             <ion-icon name="logo-youtube"></ion-icon>
     </footer>
   
</template>


<script>
export default {
    name:"the-footer"
}
</script>

<style>
.shelter-footer  {
  text-align: center;
  padding: 7px 15px;
  font-family: Montserrat, sans-serif;
  font-size: 20px;
  color: white;
  width: 100%;
  margin-bottom: 0px;
  position: fixed;
  bottom:0;
  left: 0px;
  background-color: #5c5470;;
  backdrop-filter: blur(10px);
  height: 75px;
  box-shadow: 0px 0px 5px;
}

.copy {
 padding-left: 100px;
 text-align: left;

}

ion-icon {
  position: relative;
  bottom: 20px;
  font-size: 38px;
  margin-top: -100px;
  padding: 0px 10px;
  
}

ion-icon:hover {
  background-color: #a37da3;
}

</style>


