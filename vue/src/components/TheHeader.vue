<template>
     <header class="shelter-heading">
        <img src="../assets/animalshelterlogo.png" alt="Rockville" />
      <nav>
      <ul id="primary-navigation" class="tabs">
        <li ><router-link v-bind:to="{ name: 'home' }"><button class="btn-primary">TBD</button></router-link></li>
        <li class="active"><router-link v-bind:to="{ name: 'logout' }"><button>Logout</button></router-link></li>
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
ul#primary-navigation { 
font-size: 1rem;
font-weight: bold;
list-style-type:none;
margin-right:2rem;


}
ul.tabs {
display:flex;
padding:0;
margin:0;
cursor:pointer;
transition: all 200ms ease-in;
}
ul.tabs li {
font-family: Montserrat, sans-serif;
border:none;
outline: none;
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
  color: rgb(5, 77, 53);
  text-align: center;
  background-color: #d9d9d9;
  border: 1px solid rgb(7, 78, 55);
  border-bottom: none;
  border-radius: 10px;
  box-shadow: 2px 2px 5px rgba(4, 73, 52, 0.2);
  font-family: Montserrat, sans-serif;
  border:none;
  outline: none;
}
ul.tabs li:last-child a {
  border-right: none;
}
ul.tabs li a:hover {
  background-color: #f2f2f2;
}
.shelter-heading  {
  align-items: center;
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
  height: 150px;
  box-shadow: 0px 0px 10px;
}
.shelter-heading img {
  clip-path: polygon(100% 0%, 70% 15%, 30% 15%, 0% 0%, 0% 25%, 0% 48%, 0% 75%, 24% 93%, 36% 100%, 64% 100%, 77% 93%, 100% 79%, 100% 48%, 100% 25%);
  height: 150px;
  width: 150px;
}
.shelter-heading:first-child{
  margin-right:auto;
  margin-left:2rem;

}
.primary.navigation {
    list-style: none;
    padding:0;
    margin: 0;
    background:hsl(0, 0%, 100%, 0.1);
    backdrop-filter: blur(1rem);   
}
</style>