<template>
<div class="container">
<div class='btn-container' id="btn-container">
      <button @click="selectSpecies(null)">All Pets</button>
      <button @click="selectSpecies('Dog')">Dogs</button>
      <button @click="selectSpecies('Cat')">Cats</button>
      <button @click="selectSpecies('Bird')">Birds</button>
      <button @click="selectSpecies('Guinea Pig')">Guinea Pigs</button>
      <button @click="selectSpecies('Hamster')">Hamsters</button>
    </div>
  <div class="pet-container" id="pet-container">
    <div v-for="pet in filteredPets" :key="pet.petId" class="pet-card flip-card">
      <div class="flip-card-inner">
      <div class="card-content">
        </div>
     <div class="image-container"> 
        <img :src= "pet.petPhoto" alt="Photo of Pet">
      </div>
      <a href="#" class="button">Learn More</a>
      <div>  
          <p>{{ pet. petName }}</p>
          <p>Species: {{ pet.species }}</p>
          <p> Breed: {{ pet.breed }}</p>ool
          <p>{{ pet.description }}</p>
          <router-link :to="{ name: 'UpdatePetListing', params: {id: pet.petId} }">Edit</router-link>
      </div>
      </div>
      </div>
      </div>
      </div>
      
</template>

<script>
import petservice from '../services/PetService';
export default {
  name: "view-pets",
  data() {
    return {
       selectedSpecies:null
    }
    },
    mounted() {
  this.retrievePets();
},
  methods: {
    retrievePets(){
      petservice.findAllPets().then((response) => {
        this.$store.commit("SET_PET_INFO", response.data);
      });
    }, 
    selectSpecies(species) {
    this.selectedSpecies = species
  }

  },
  computed: {
      pets() {
          return this.$store.state.pets;
      },
      filteredPets() {
    if (!this.selectedSpecies) {
      return this.$store.state.pets
    }
    return this.$store.state.pets.filter(pet => pet.species === this.selectedSpecies)
  }
}
  }
</script>


<style>
@import url('https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300&family=Poppins:wght@300;400;500&display=swap');
.pet-container{
  font-family: Montserrat, sans-serif;
  display:flex;
  flex-wrap: wrap;
  justify-content: center;
  align-items:flex-start;
  height: 300px;
  position:static;
  top:325px;
  padding: 0 2px;
  margin-top: 50px;
  max-width: 1200px;
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
    position:relative;
    margin: 10px;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    display: flex;
    flex-direction: column;
    align-items: center;
    max-width: 300px;
    background-color: rgba(93, 11, 93, 0.7);
    backdrop-filter: blur(10px);
    box-shadow: 0px 5px 10px rgba(0,0,0,0.2);
    transition: transform 500ms ease;
    background-color: rgba(139, 100, 139, 0.8);
    z-index: 1;
    font-weight: bold;
    flex-basis: calc(50% - 20px);
    margin: 10px;

  }
  .flip-card {
    perspective: 1000px;
  }
  .flip-card-inner {
    position:relative;
    width:100%;
    height:100%;
    transition: transform 0.6s;
    transform-style: preserve-3d;
  }
  .pet-card:hover .flip-card-inner {
    transform: rotateY(180deg)
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
    background-color: lightsteelblue;
  }
  .card-content {
    position: absolute;
    width: 100%;
    height: 100%;
    backface-visibility: hidden;
    transform: translateY(0%);
    transition: transform 500ms ease;
  } .card-content.back {
  transform: rotateY(180deg);
}
 
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
.btn {
  border: none;
  outline: none;
  padding: 12px 16px;
  background-color: #f1f1f1;
  cursor: pointer;
}
.btn:hover {
  background-color: #ddd;
}
.btn.active {
  background-color: #666;
  color: white;
}
.btn-container{
  
  display:flex;
  justify-content: center;
  margin-top:50px;

}
#pet-container{
  height:500px;
}
button {
  height: -100px;
  z-index: 2;
  background-color: rgb(195, 226, 199);
}

  .pet-card:hover .card-content {
  transform: translateY(0);
  
  }
</style>