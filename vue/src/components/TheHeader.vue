<template>
     <header class="shelter-heading">
        <img src="../assets/animalshelterlogo.png" alt="Rockville" />
      <nav>
      <ul id="primary-navigation" class="tabs">
        <li ><router-link v-bind:to="{ name: 'home' }"><button>TBD</button></router-link></li>
        <li class="active"><router-link v-bind:to="{ name: 'logout' }"><button>Logout</button></router-link></li>
        <li><router-link v-bind:to="{ name: 'volunteer-register' }"><button>Register as Volunteer</button></router-link></li>
      </ul>
    </nav>
    </header>
</template>

<script>
//import { component } from 'vue/types/umd'
import volunteerRegister from '../views/VolunteerRegister.vue'
export default {
    name:"the-header",
    component: { volunteerRegister}
}
</script>

<style>
ul#primary-navigation {
font-weight: bold;
list-style-type:none;

}
ul.tabs {
display:flex;
padding:0;
margin:0;
}
ul.tabs li {
  flex: 1; 
}
ul.tabs li.active a {
  background-color: #034f3c;
  color: white;
  border-radius: 10px;
}
ul.tabs li a {
  display: block;
  padding: 10px 20px;
  text-decoration: none;
  color: black;
  text-align: center;
  background-color: #d9d9d9;
  border: 1px solid black;
  border-bottom: none;
  border-radius: 10px;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
}
ul.tabs li:last-child a {
  border-right: none;
}
ul.tabs li a:hover {
  background-color: #f2f2f2;
}
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
  background-color: rgba(3, 79, 60, 0.7);
  backdrop-filter: blur(10px);
  height: 200px;
}
.shelter-heading img {
  clip-path: polygon(100% 0%, 70% 15%, 30% 15%, 0% 0%, 0% 25%, 0% 48%, 0% 75%, 24% 93%, 36% 100%, 64% 100%, 77% 93%, 100% 79%, 100% 48%, 100% 25%);
  height: 200px;
}
.primary.navigation {
    list-style: none;
    padding:0;
    margin: 0;
    background:hsl(0, 0%, 100%, 0.1);
    backdrop-filter: blur(1rem);
    
}

</style>