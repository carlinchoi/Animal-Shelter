<template>
     <header class="shelter-heading">
        <img src="../assets/animalshelterlogo.png" alt="Rockville" />
         <nav>
      <ul id="primary-navigation">
        <li ><router-link v-bind:to="{ name: 'home' }"><button>TBD</button></router-link></li>
        <li class="active"><router-link v-bind:to="{ name: 'login' }"><button>Logout</button></router-link></li>
      </ul>
    </nav>
    </header>
</template>

<script>
export default {
    name:"the-header"

}
</script>

<style>
ul#primary-navigation .active {
font-weight: bold;
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
}
.shelter-heading img {
    border-radius: 25px;
}
.primary.navigation {
    list-style: none;
    padding:0;
    margin: 0;
    background:hsl(0, 0%, 100%, 0.1);
    backdrop-filter: blur(1rem);
    
}

</style>