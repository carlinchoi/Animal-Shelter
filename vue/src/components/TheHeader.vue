<template>
<div>
  
    <nav>
      <div class="logo-container">
        <img src="../assets/animalshelterlogo.png" alt="Rockville" />
      </div>
      <ul>
        <li><router-link :to="{name: 'home' }">Browse Pets</router-link></li>
        <li><a href="#">Donate</a></li>
        <li><router-link v-bind:to="{ name: 'volunteer-register' }">Apply to Volunteer</router-link></li>
        <li v-if="showLoginButton"><router-link v-bind:to="{ name: 'login' }">Login</router-link></li>
        <li v-if="showNewPetButton"><router-link v-bind:to="{ name: 'add-pet-listing' }">Add New Pet Listing</router-link></li>
        <li class="active" v-if="showLogoutButton"><router-link v-bind:to="{ name: 'logout' }">Logout</router-link></li>
        <li><a href="#"><input type="text" placeholder="Search"></a></li>
      </ul>
    </nav>
    
</div>
</template>

<script>
export default {
  name: "the-header",
  computed: {
    showLogoutButton() {
      return this.$route.name === "home";
    },
    showLoginButton() {
      return this.$route.name === "register" || this.$route.name === "volunteer-register";
    },
    showNewPetButton() {
      return this.$route.name === "home";
    }
  },
};
</script>
<style scoped>
div{
  z-index: 9999;
}
nav {
  background-color: rgba(15, 83, 66, 0.8);
  color: white;
  font-weight: bold;
  height: 200px;
  position: fixed;
  top: 0;
  left: 0;
  right:0;

  width: 100%;
  z-index: 1;
}
.logo-container {
position:relative;
}

nav ul {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  list-style-type: none;
  margin: 0;
  padding: 0;
  height: 336px;
}

nav ul {
  margin: 0;
  font-size:20px;
  border-radius: 10px;
 
 
}

nav a {
  position: relative;
  color: white;
  display: block;
  padding: 20px;
  text-decoration: none;
}

nav a:hover {
  background-color: #a37da3;
}

nav .active {
  background-color: #99bdbc;
  transition: background-color 0.3s ease-out;
}

header {
  background-color: #d9d9d9;
  padding: 20px;
  margin-top: 60px;
}
.logo-container img {
position: absolute;
  top: 0;
  left:0;
clip-path: polygon(100% 0%, 70% 15%, 30% 15%, 0% 0%, 0% 25%, 0% 48%, 0% 75%, 24% 93%, 36% 100%, 64% 100%, 77% 93%, 100% 79%, 100% 48%, 100% 25%); 
  height: 190px;
  z-index: 1;
  padding: 5px;
  background-color: transparent;
  border: black;
}
</style>