<template>
  <!-- <div>
      <table>
          <thead>
              <tr>
                  <th>Pet</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="pet in this.$store.state.pets" :key="pet.petId">
                  <td >{{ pet.petId }}</td>
                  <td> {{ pet.petName }}</td>
                  <td>{{ pet.gender }}</td>
              </tr>
          </tbody>
      </table>
  </div> -->
  <div class="pet-container">
    <div v-for="pet in this.$store.state.pets" :key="pet.petId" class="pet-card">
      <div class="card-content">
     <div class="image-container"> 
        <img :src= "pet.petPhoto" alt="Photo of Pet">
      </div>
      <a href="#" class="button">Learn More</a>
      <div>  
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
@import url('https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300&family=Poppins:wght@300;400;500&display=swap');
.pet-container{
  font-family: Montserrat, sans-serif;
  display:flex;
  flex-wrap: wrap;
  justify-content: center;
  height: 500px;
  position:fixed;
  top:325px;
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
    transform: translateY(5%);
    transition: transform 500ms ease;
  } 
  .pet-card:hover .card-content {
  transform: translateY(0);
  
  }
</style>