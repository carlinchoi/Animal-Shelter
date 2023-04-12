<template>
<div>
    <nav>
      <!-- <div class="logo-container">
        <img src="../assets/animalshelterlogo.png" alt="Rockville" />
      </div> -->
      <div class="search-container">
      </div>
      <ul>
        <li><a href="#">Home</a></li>
        <li><a href="#">Adoption</a></li>
        <li><a href="#">Donate</a></li>
        <li><router-link v-bind:to="{ name: 'volunteer-register' }">Register to Volunteer</router-link></li>
        <li class="active" v-if="showLogoutButton"><router-link v-bind:to="{ name: 'logout' }">Logout</router-link></li>
        <li v-if="showLoginButton"><router-link v-bind:to="{ name: 'login' }"><button>Login</button></router-link></li>
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
  },
};
</script>
<style scoped>
nav {
  background-color: #0f5342;
  color: white;
  font-weight: bold;
  height: 80px;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1;
}
.logo-container {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-left:0;
}


nav ul {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  list-style-type: none;
  margin: 0;
  padding: 0;
}

nav li {
  margin: 0;
  font-size:20px;

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
/* .logo-container img {
  clip-path: polygon(100% 0%, 70% 15%, 30% 15%, 0% 0%, 0% 25%, 0% 48%, 0% 75%, 24% 93%, 36% 100%, 64% 100%, 77% 93%, 100% 79%, 100% 48%, 100% 25%);
  height: 80px;
  width: 80px;
  margin-top: 200px;
} */
</style>