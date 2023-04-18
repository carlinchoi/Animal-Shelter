<template>
  <div>
    <nav>
      <div class="logo-container">
        <img src="../assets/animalshelterlogo.png" alt="Rockville" />
      </div>
      <ul>
        <li><router-link :to="{ name: 'home' }">Browse Pets</router-link></li>
        <li><router-link :to="{ name: 'view-adoptions' }">Adopted Pets</router-link></li>
        <li>
          <router-link v-bind:to="{ name: 'volunteer-register' }"
            >Apply to Volunteer</router-link
          >
        </li>
        <li v-if="showLoginButton">
          <router-link v-bind:to="{ name: 'login' }">Login</router-link>
        </li>
        <li v-if="showNewPetButton">
          <router-link v-bind:to="{ name: 'add-pet-listing' }"
            >Add New Pet Listing</router-link
          >
        </li>
        <li v-if="isVolunteerOrAdmin">
          <router-link v-bind:to="{ name: 'volunteer-listing' }">View Volunteers</router-link>
        </li>
        <li v-if="isAdmin">
          <router-link v-bind:to="{ name: 'volunteer-pending-list' }">Approve Volunteers</router-link>
        </li>
        <li class="active" v-if="showLogoutButton">
          <router-link v-bind:to="{ name: 'logout' }">Logout</router-link>
        </li>
        <li v-if="showRegisterButton">
          <router-link v-bind:to="{ name: 'register' }">Register</router-link>
        </li>
      
       

        <!-- <li v-if="showVolunteersButton">
          <router-link v-bind:to="{ name: 'login' }">Show Volunteers</router-link>
        </li> -->
      </ul>
    </nav>
  </div>
</template>

<script>
export default {
  name: "the-header",
  computed: {
    showLogoutButton() {
      return (
      this.$route.name === "home" ||
      this.$route.name === "view-adoptions" ||
      this.$route.name === "volunteer-listing" ||
      this.$route.name === "volunteer-pending-list"
      );
    },
    showLoginButton() {
      return (
        this.$route.name === "register" ||
        this.$route.name === "volunteer-register"
      );
    },
    showNewPetButton() {
      return this.$route.name === "home";
    },
    showRegisterButton() {
      return this.$route.name === "register" || this.$route.name === "login";
    },
    isVolunteerOrAdmin() {
      return this.$store.state.user.authorities[0].name.includes('ROLE_VOLUNTEER') || this.$store.state.user.authorities[0].name.includes('ROLE_ADMIN');
    },
    isAdmin() {
      return this.$store.state.user.authorities[0].name.includes('ROLE_ADMIN');
    }
  },
};
</script>
<style scoped>
nav {
  background-color: rgba(15, 83, 66, 0.8);
  color: white;
  font-weight: bold;
  height: 160px;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  width: 100%;
  z-index: 50;
}
nav.hidden {
  top: -200px;
}
.logo-container {
  position: relative;
}

nav ul {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  list-style-type: none;
  margin: 0;
  padding: 0;
  height: 250px;
}

nav li {
  margin: 0;
  font-size: 25px;
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
  left: 0;
  width: 225px;
  clip-path: polygon(
    100% 0%,
    70% 15%,
    30% 15%,
    0% 0%,
    0% 25%,
    0% 48%,
    0% 75%,
    24% 93%,
    36% 100%,
    64% 100%,
    77% 93%,
    100% 79%,
    100% 48%,
    100% 25%
  );
  height: 150px;
  z-index: 1;
  padding: 5px;
}

@media only screen and (max-width: 768px) {
  nav {
    height: 200px;
  }

  nav ul {
    flex-direction: column;
    height: 100%;
    margin-top: 0;
  }

  nav li {
    margin: 0 10px;
    font-size: 25px;
  }
  .logo-container {
    display: none;
  }
  .logo-container img {
    height: 190px;
  }
}
</style>