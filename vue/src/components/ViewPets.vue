<template>
  <div class="pet-container">
    <div v-for="pet in this.$store.state.pets" :key="pet.petId" class="pet-card">
      <div class="card-content">
     <div class="image-container"> 
        <img :src= "pet.petPhoto" alt="Photo of Pet">
      </div>
      <a href="#" class="button">Learn More</a>
      <div class="text-box">  
          <p>{{ pet. petName }}</p>
          <p>Species: {{ pet.species }}</p>
          <p> Breed: {{ pet.breed }}</p>
          <p>{{ pet.description }}</p>
      </div>
      </div>
      </div>
      <router-link v-bind:to="{ name: 'add-pet-listing' }"><button class="btn-primary">Add New Pet Listing</button></router-link>
      </div>
     
</template>

<script>
import petservice from '../services/PetService';
export default {
  name: "view-pets",
  methods: {
    retrievePets(){
      petservice.findAllPets().then((response) => {
        this.$store.commit("SET_PET_INFO", response.data);
      });
    }
  },
  computed: {
      pets() {
          return this.$store.state.pets;
      }
  },
  created(){
    this.retrievePets();
    // this.retrievePets().then((response) => {
    //   this.pets = response.data;
    // })
  },
};
</script>


<style>
.pet-container{
  font-family: Montserrat, sans-serif;
  display:flex;
  flex-wrap: wrap;
  justify-content: center;
  height: 500px;
  position:fixed;
  top:325px;
  margin-top: -100px;
}
  img {
    width: 300px;
    height: 300px;
    object-fit: cover;
  }
  .image-container {
    display: flex;
    flex-direction: row;
    justify-content: center;
    border-radius: 5px;
    align-items: center;
    height: 300px;
    width: 300px;
    overflow-y: hidden;
  }
  .pet-card {
    
    margin: 10px;
    padding: 40px;
    border: 1px solid #ccc;
    border-radius: 5px;
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 300px;
    background-color: #8b648b;
    box-shadow: 0px 5px 10px rgba(0,0,0,0.2);
    transition: transform 500ms ease;
    background-color: rgba(139, 100, 139, 0.8);
    z-index: 1;
    font-weight: bold;
    
  }
  .pet-card:hover {
  transform: scale(1.05);
  }
  .button {
    cursor:pointer;
    display: inline;
    text-decoration:none;
    color: black;
    background-color: rgb(195, 226, 199);
    padding: 0.5em 1.25em;
    border-radius: 0.25em;
  }
  .button:hover,
  .button:focus {
    background-color: rgb(221, 176, 222);
  }
  .card-content {
    transform: translateY(0%);
    transition: transform 500ms ease;
  } 
  /* .pet-card:hover .card-content {
  transform: translateY(0);
  } */
  .text-box {
    background-color: white;
    padding: 10px;
    border-radius: 5px;
  }
  .logo {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 50px;
}

.logo img {
  max-width: 400px;
  max-height: 200px;
}
</style>