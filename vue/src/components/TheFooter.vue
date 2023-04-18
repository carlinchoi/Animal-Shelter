<template>
     <footer class="shelter-footer"> 
          <p class="copy"> &copy; 2023 Rockville Animal Shelter. All rights reserved.</p>   
          <p class="contact"> Contact Us </p> 
          <p class="adopted"> Adopted Pets </p>   
          <ion-icon name="logo-instagram"></ion-icon>
          <ion-icon name="logo-facebook"></ion-icon>
          <ion-icon name="logo-youtube"></ion-icon>
          <router-link :to="{name: 'home' }"><ion-icon name="home"></ion-icon></router-link>
          <button><router-link :to="{name: 'view-adoptions' }">Adopted Pets</router-link></button>
 
     </footer>
</template>

<script>
export default {
    name:"the-footer"
}
</script>

<style scoped>
.shelter-footer  {
  z-index: 5;
  text-align: center;
  padding: 7px 15px;
  font-family: Montserrat, sans-serif;
  font-size: 20px;
  font-weight: bold;
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
  position: relative;
  padding-left: 100px;
  text-align: left;
  color: white;
  bottom: 0px;

}
.contact {
  position: relative;
  bottom: 42px;
  padding-right: 185px;
  text-align: right;
  text-decoration: underline;
  text-decoration-color: rgb(195, 226, 199);
  color: white;
  font-size: 22px;
 
}
.adopted {
  position: relative;
  bottom: 90px;
  padding-right: 315px;
  text-align: right;
  text-decoration: underline;
  text-decoration-color: rgb(195, 226, 199);
  color: white;
  font-size: 22px;
}
ion-icon {
  position: relative;
  bottom: 125px;
  font-size: 38px;
  margin-top: -100px;
  padding: 0px 10px;
  color: rgb(195, 226, 199);
  
}

ion-icon:hover {
  background-color: #a37da3;
  border-radius: 25%;
}

@media (max-width: 768px) {
  .shelter-footer {
    display: none;
  }
}
</style>


